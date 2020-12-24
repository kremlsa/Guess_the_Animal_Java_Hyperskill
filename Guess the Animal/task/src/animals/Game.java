package animals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Game {
    boolean isRun = true;
    static Scanner sc = new Scanner(System.in);
    static Animal animalF;
    static Animal animalS;
    static Facts facts = new Facts();
    static String fact;
    KTree kt = new KTree();

    public KTree start() {
        Greetings.say();
        if (loadKtree()) {
            kt.setParents(kt.root);

        } else {
            /*System.out.println("I want to learn about animals.\n" +
                    "Which animal do you like most?\n");*/
            System.out.println(L10in.getAskAnimal());
            animalF = new Animal(sc.nextLine());
            /*System.out.println("Wonderful! I've learned so much about animals!\n" +
                    "Let's play a game!");*/
            kt.addRoot(animalF.getNameA());
        }
        //System.out.println("Welcome to the animal expert system!\n");
        System.out.println(L10in.getWelcome());
        boolean isWork = true;
        while (isWork) {
            System.out.println(L10in.getTitle() + "\n" +
                    "\n" +
                    "1. " + L10in.getMenu1() + "\n" +
                    "2. " + L10in.getMenu2() + "\n" +
                    "3. " + L10in.getMenu3() + "\n" +
                    "4. " + L10in.getMenu4() + "\n" +
                    "5. " + L10in.getMenu5() + "\n" +
                    "0. " + L10in.getMenu0() + "\n");
            String options = sc.nextLine();
            switch (options) {
                case "1" :
                    playGame();
                    break;
                case "2" :
                    listAnimals();
                    break;
                case "3" :
                    searchAnimal();
                    break;
                case "4" :
                    stats();
                    break;
                case "5" :
                    printKt();
                    break;
                case "0" :
                    isWork = false;
                    break;
            }
        }
        GoodBye.say();
        return kt;

    }

    public void listAnimals() {
        System.out.println("Here are the animals I know:");
        kt.listAnimals();

    }

    public void searchAnimal() {
        System.out.println(L10in.searchAnimal());
        String input = sc.nextLine();
        kt.find(input);
    }

    public void stats() {
        kt.stats();

    }

    public void printKt() {
        //kt.print();

    }


    public void playGame() {

        boolean isSkip = false;
        Node check = kt.root;
        String answer;

        while(isRun) {
            if (!isSkip) {
                /*System.out.println("You think of an animal, and I guess it.\n" +
                        "Press enter when you're ready.");*/
                System.out.println(L10in.getThink() + ".\n" +
                        L10in.getEnter());
                check = kt.root;
                sc.nextLine();
            }
            isSkip = false;
            if (check.value.toLowerCase().startsWith("it") ||
                    check.value.toUpperCase().startsWith("ĜI")) {
                System.out.println(facts.getQuestion(check.value) + "?");
                answer = sc.nextLine();
                while (true) {
                    if (Answers.checkAnswer(answer).equals("Yes")) {
                        check = check.right;
                        isSkip = true;
                        break;
                    } else if (Answers.checkAnswer(answer).equals("No")) {
                        check = check.left;
                        isSkip = true;
                        break;
                    } else {
                        Questions.say();
                        answer = sc.nextLine();
                    }
                }
            } else {
                animalF = new Animal(check.value);
                System.out.println(MessageFormat.format(L10in.getAnimalQuestion(), animalF.getNameA()));
                //System.out.println("Is it " + animalF.getNameA() + "?");
                answer = sc.nextLine();
                while (true) {
                    if (Answers.checkAnswer(answer).equals("Yes")) {
                        System.out.println("I win");
                        break;
                    } else if (Answers.checkAnswer(answer).equals("No")) {
                        //System.out.println("I give up. What animal do you have in mind?");
                        System.out.println(L10in.getGiveUp());
                        animalS = new Animal(sc.nextLine());
                        boolean isSecondToLeft = addFacts();
                        String temp = check.value;
                        check.value = fact;
                        if (isSecondToLeft) {
                            check.left = new Node();
                            check.left.setValue(animalS.getName());
                            check.right = new Node();
                            check.right.setValue(temp);
                        } else {
                            check.right = new Node();
                            check.right.setValue(animalS.getName());
                            check.left = new Node();
                            check.left.setValue(temp);
                        }
                        break;
                    } else {
                        Questions.say();
                        answer = sc.nextLine();
                    }
                }
            }

            if (isSkip) continue;

            //System.out.println("Would you like to play again?");
            System.out.println(L10in.playAgain().split("\f")[0]);

            //isRun = sc.nextLine().equals("yes");
            answer = sc.nextLine();
            while (true) {
                if (Answers.checkAnswer(answer).equals("Yes")) {
                    isRun = true;
                    break;
                } else if (Answers.checkAnswer(answer).equals("No")) {
                    isRun = false;
                    break;
                } else {
                    Questions.say();
                    answer = sc.nextLine();
                }
            }
            System.out.println();
        }
        System.out.println();
        GoodBye.say();
        Utils.saveToJson2(kt.root);
    }

    public static boolean addFacts() {
        boolean result = false;
        //System.out.println(MessageFormat.format(L10in.getAnimalQuestion(), animalF.getNameA()));
        System.out.println(MessageFormat.format(L10in.specifyFact(), animalF.getNameA(), animalS.getNameA()) + ".\n" +
                L10in.statement() + "\n");
        fact = sc.nextLine();
        while (true) {
            String response = Answers.checkFact(fact);
            if (response.startsWith("The examples")) {
                System.out.println(L10in.statementExample());
                fact = sc.nextLine();
            } else {
                break;
            }
        }
        //System.out.println("Is the statement correct for " + animalS.getNameA() + "?");
        System.out.println(MessageFormat.format(L10in.statementIsCorrect(), animalS.getNameA()));
        String answer = sc.nextLine();
        while (true) {
            if (Answers.checkAnswer(answer).equals("Yes")) {
                facts.addFacts(fact, animalS);
                System.out.println(L10in.statementLearn() + "\n" +
                        " - " + L10in.getThe() + " " + animalF.getName()  + facts.negativeFacts(fact) + ".\n" +
                        " - " + L10in.getThe() + " " + animalS.getName() + " " + facts.positiveFacts(fact) + ".\n");
                break;
            } else if (Answers.checkAnswer(answer).equals("No")) {
                facts.addFacts(fact, animalF);
                System.out.println("I learned the following facts about animals:\n" +
                        " - " + L10in.getThe() + " " + animalF.getName() + " " + facts.positiveFacts(fact) + ".\n" +
                        " - " + L10in.getThe() + " " + animalS.getName()  + facts.negativeFacts(fact) + ".\n");
                L10in.nameReplace();
                result = true;
                break;
            } else {
                Questions.say();
                answer = sc.nextLine();
            }
        }
        System.out.println("I can distinguish these animals by asking the question:\n" +
                " - " + facts.getQuestion(fact) + "?");
        System.out.println(L10in.nice().split("\f")[0] + " " + L10in.knowMore() + "\n");
        return result;

    }

    public boolean loadKtree() {
        if (Utils.loadFromJson() != null) {
            kt.root = Utils.loadFromJson();
            return  true;
        } else if (Utils.loadFromXml() != null) {
            kt.root = Utils.loadFromXml();
            return  true;
        } else if (Utils.loadFromYaml() != null) {
            kt.root = Utils.loadFromYaml();
            return  true;
        } else {
            return false;
        }
    }

}

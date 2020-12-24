package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Answers {
    public static List<String> yesAnswers = new ArrayList<String>(
            Arrays.asList("y", "yes", "yeah", "yep", "sure", "right",
                    "affirmative", "correct", "indeed",
                    "you bet", "exactly", "you said it", "j", "jes", "certe"));
    public static List<String> noAnswers = new ArrayList<String>(
            Arrays.asList("n", "no", "no way", "nah", "nope", "negative",
                    "I don't think so", "yeah no", "n", "ne"));

    public static String checkAnswer(String answer) {
        for (String s : yesAnswers) {
            s = s.toLowerCase();
            answer = answer.trim().toLowerCase();
            if (answer.matches(s + "[.!]?")) {
                return "Yes";
            }
        }

        for (String s : noAnswers) {
            s = s.toLowerCase();
            answer = answer.trim().toLowerCase();
            if (answer.matches(s + "[.!]?")) {
                return "No";
            }
        }

        return  "Come on, yes or no?";
    }

    public static String checkFact(String fact) {
        fact = fact.toLowerCase();
        //if (fact.startsWith("it can") ||  fact.startsWith("it has") || fact.startsWith("it is")) {
        if (fact.matches(L10in.statementRegex())) {
            return "fact";
        } else {
            return "The examples of a statement:\n" +
                    " - It can fly\n" +
                    " - It has horn\n" +
                    " - It is a mammal\n" +
                    "Specify a fact that distinguishes a cat from a shark.\n" +
                    "The sentence should be of the format: 'It can/has/is ...'.\n";
        }
    }


}

package animals;

import java.util.ResourceBundle;

public class L10in {
    static ResourceBundle menus = ResourceBundle.getBundle("main-menu");

    public static String getMenu1() {
        return menus.getString("play");
    }

    public static String getMenu2() {
        return menus.getString("list");
    }

    public static String getMenu3() {
        return menus.getString("search");
    }

    public static String getMenu4() {
        return menus.getString("stats");
    }

    public static String getMenu5() {
        return menus.getString("print");
    }

    public static String getMenu0() {
        return menus.getString("exit");
    }

    public static String getTitle() {
        return menus.getString("title");
    }

    public static String getError() {
        return menus.getString("error");
    }

    static ResourceBundle apps = ResourceBundle.getBundle("application");

    public static String getWelcome() {
        return apps.getString("welcome");
    }

    public static String getFarewell() {
        return apps.getString("goodbye");
    }

    public static String getAskAnimal() {
        return apps.getString("ask.favorite.animal");
    }

    public static String fileJ() {
        return apps.getString("fileJ");
    }

    public static String fileX() {
        return apps.getString("fileX");
    }

    public static String fileY() {
        return apps.getString("fileY");
    }

    public static String searchAnimal() {
        return apps.getString("search.animal");
    }

    public static String searchNF() {
        return apps.getString("search.not_found");
    }

    public static String searchFact() {
        return apps.getString("search.facts");
    }

    public static String searchIt() {
        return apps.getString("it");
    }

    static ResourceBundle games = ResourceBundle.getBundle("game");

    public static String getThink() {
        return games.getString("think");
    }

    public static String getEnter() {
        return games.getString("enter");
    }

    public static String getGiveUp() {
        return games.getString("give.up");
    }

    public static String specifyFact() {
        return games.getString("specify.fact");
    }

    public static String statement() {
        return games.getString("statement.format");
    }

    public static String statementExample() {
        return games.getString("statement.example");
    }

    public static String statementRegex() {
        return games.getString("statement.regex");
    }

    public static String statementIsCorrect() {
        return games.getString("is.correct");
    }

    public static String statementLearn() {
        return games.getString("learned");
    }

    public static String nice() {
        return games.getString("nice");
    }

    public static String knowMore() {
        return games.getString("know.more");
    }

    public static String playAgain() {
        return games.getString("again");
    }

    static ResourceBundle domain = ResourceBundle.getBundle("domain");

    public static String getAnimalQuestion() {
        return domain.getString("animal.question");
    }

    public static String getArticleA() {
        return domain.getString("animal.articleA");
    }

    public static String getArticleAn() {
        return domain.getString("animal.articleAn");
    }

    public static String factAnimal() {
        return domain.getString("statement.fact.animal");
    }

    public static String nameReplace() {
        return domain.getString("animal.name.replace");
    }

    public static String getIt() {
        return domain.getString("it");
    }

    public static String getThe() {
        return domain.getString("the");
    }

    public static String getIs() {
        return domain.getString("is");
    }

    public static String getHas() {
        return domain.getString("has");
    }

    public static String getCan() {
        return domain.getString("can");
    }

    public static String getIsn() {
        return domain.getString("isn");
    }

    public static String getHasn() {
        return domain.getString("hasn");
    }

    public static String getCann() {
        return domain.getString("cann");
    }

    public static String getIsy() {
        return domain.getString("isy");
    }

    public static String getHasy() {
        return domain.getString("hasy");
    }

    public static String getCany() {
        return domain.getString("cany");
    }

    static ResourceBundle stats = ResourceBundle.getBundle("tree-statistics");

    public static String statRoot() {
        return stats.getString("root");
    }

    public static String statNodes() {
        return stats.getString("nodes");
    }

    public static String statAn() {
        return stats.getString("animals");
    }

    public static String statS() {
        return stats.getString("statements");
    }

    public static String statH() {
        return stats.getString("height");
    }

    public static String statM() {
        return stats.getString("minimum");
    }

    public static String statA() {
        return stats.getString("average");
    }

    public static String statT() {
        return stats.getString("title");
    }






   // var helloString = appResource.getString("hello"));
   // var byeStringArray = appResource.getStringArray("bye"));
   // var animalName = (UnaryOperator) appResource.getObject("animal.name");
}

package animals;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Animal animalF;
    static Animal animalS;
    static Facts facts = new Facts();
    static String format = "json";

    public static void main(String[] args) {
        if (args.length > 0) {
            format = args[1];
        }
        Game game = new Game();
        KTree kt = game.start();
        switch (format.toLowerCase()) {
            case "json":
                Utils.saveToJson(kt.root);
                break;
            case "yaml":
                Utils.saveToYaml(kt.root);
                break;
            case "xml":
                Utils.saveToXml(kt.root);
                break;
        }
    }
}

package animals;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    String name;
    String article;
    List<String> facts;

    Animal(String name) {
        facts = new ArrayList<String>();
        this.name = name.toLowerCase();
        if (this.name.startsWith("a ") || this.name.startsWith("an ")) {
            article = "";
        } else {
            if (this.name.matches("([aeiouy])\\w*")) {
                article = "an ";
            } else {
                article = "a ";
            }
        }

    }

    public void addFact(String fact){
        facts.add(fact);
    }

    public String getNameA() {
        if (article.equals("an ")) {
            return L10in.getArticleAn() + name;
        } else if (article.equals("a ")) {
            return L10in.getArticleA() + name;
        }
        return article + name;
    }

    public String getName() {
        if (this.name.startsWith("a ") || this.name.startsWith("an ")) {
            name = name.replace("a ", "");
            name = name.replace("an ", "");
            return name;
        }
        return name;
    }

    public List<String> getFacts() {
        return facts;
    }
}

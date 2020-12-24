package animals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Facts {

    public Map<String, Animal> facts;

    public Facts() {
        this.facts = new LinkedHashMap<String, Animal>();
    }

    public void addFacts(String fact, Animal animal) {
        facts.put(fact.toLowerCase(), animal);
    }

    public boolean itHas(Animal animal) {
        String name = animal.getName();
        for (Map.Entry<String, Animal> entry : facts.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String positiveFacts(String fact) {
        fact = fact.toLowerCase().replaceFirst(L10in.getIt(), "");
        return fact.replace("?", "");
    }

    public String negativeFacts(String fact) {
        fact =  fact.toLowerCase().replaceFirst(L10in.getIt(), " ");
        fact = fact.replaceFirst(L10in.getIs(), L10in.getIsn());
        fact = fact.replaceFirst(L10in.getHas(), L10in.getHasn());
        fact = fact.replaceFirst(L10in.getCan(), L10in.getCann());
        fact = fact.replace("?", "");
        return fact;
    }

    public String getQuestion(String fact) {
        fact = fact.trim().toLowerCase();
        fact = fact.replaceFirst(L10in.getIt(), " ");
        fact = fact.replaceFirst(L10in.getIs(), L10in.getIsy());
        fact = fact.replaceFirst(L10in.getHas(), L10in.getHasy());
        fact = fact.replaceFirst(L10in.getCan(), L10in.getCany());
        fact = fact.replace("?", "");
        return fact;
    }

}

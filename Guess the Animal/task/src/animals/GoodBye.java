package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GoodBye {

    public static List<String> farewell = new ArrayList<String>(
            Arrays.asList("Good bye", "Good bye", "Good bye"));

    public static void say() {
        Random rand = new Random();
        //System.out.println(farewell.get(rand.nextInt(3)));
        System.out.println(L10in.getFarewell());
    }
}

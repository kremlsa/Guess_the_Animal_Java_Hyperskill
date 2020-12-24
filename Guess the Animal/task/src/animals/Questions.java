package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Questions {

    public static List<String> questions = new ArrayList<String>(
            Arrays.asList("I'm not sure I caught you: was it yes or no?",
                    "Funny, I still don't understand, is it yes or no?",
                    "Oh, it's too complicated for me: just tell me yes or no."
            ));

    public static void say() {
        Random rand = new Random();
        System.out.println(questions.get(rand.nextInt(3)));
    }
}

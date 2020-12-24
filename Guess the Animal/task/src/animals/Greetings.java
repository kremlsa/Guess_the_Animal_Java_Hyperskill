package animals;

import java.time.LocalDateTime;
import java.time.temporal.ValueRange;

public class Greetings {
    public static void say() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.getHour() > 5 && currentTime.getHour() < 12) {
            System.out.println("Good morning");
        }
        if (currentTime.getHour() > 12 && currentTime.getHour() < 18) {
            System.out.println("Good afternoon");
        }
        if (currentTime.getHour() > 18 && currentTime.getHour() < 5) {
            System.out.println("Good evening");
        }

    }
}

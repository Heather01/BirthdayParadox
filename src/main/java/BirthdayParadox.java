
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;

public class BirthdayParadox {


    private static final Random randomBday = new Random();
    private static final int numTimes = 1000;
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    private static float runExperiment(int numPeople, int numTimes) {
        int people = 0;
        for(int i = 0; i < numTimes; i++) {
            if(experiment(numPeople)) {
                people+=1;
            }
        }
        float times =(float) people/numTimes;
        return times * 100;
    }

    private static boolean experiment(int people) {
        HashSet<Integer> birthdays = new HashSet<Integer>();

        for (int i = 0; i < people; i++) {
            int day = randomBday.nextInt(365);

            if (birthdays.contains(day)) {
                return true;
            }

            birthdays.add(day);
        }
        return false;
    }

    static void run(){

        for (int i = 5; i < 101; i+=5){

            System.out.println("When there is " + i + " people the chance of 2 sharing the" +
                    "same birthday is " + runExperiment(i, numTimes));

        }
    }

}

import java.util.Arrays;

public class TrainApp {

    // UC17: Sort bogie names using Arrays.sort()
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames); // built-in sorting
    }

    public static void main(String[] args) {

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting: " + Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("After Sorting: " + Arrays.toString(bogieNames));
    }
}
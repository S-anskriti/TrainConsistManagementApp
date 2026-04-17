import java.util.Arrays;

public class TrainApp {

    // UC18: Linear Search for Bogie ID
    public static boolean searchBogieById(String[] bogieIds, String searchKey) {

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(searchKey)) {
                return true; // found → stop early
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        System.out.println("Bogie List: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        boolean found = searchBogieById(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID found in the consist.");
        } else {
            System.out.println("Bogie ID not found.");
        }
    }
}
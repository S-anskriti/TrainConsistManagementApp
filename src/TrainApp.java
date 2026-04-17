import java.util.Arrays;

public class TrainApp {

    // UC19: Binary Search for Bogie ID
    public static boolean binarySearchBogie(String[] bogieIds, String searchKey) {

        // Handle empty array
        if (bogieIds.length == 0) {
            return false;
        }

        // Ensure sorted input (important requirement)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(searchKey);

            if (comparison == 0) {
                return true; // found
            } 
            else if (comparison < 0) {
                low = mid + 1; // search right
            } 
            else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchKey = "BG205";

        System.out.println("Before Sorting: " + Arrays.toString(bogieIds));

        boolean found = binarySearchBogie(bogieIds, searchKey);

        System.out.println("After Sorting: " + Arrays.toString(bogieIds));

        if (found) {
            System.out.println("Bogie ID found using Binary Search.");
        } else {
            System.out.println("Bogie ID not found.");
        }
    }
}
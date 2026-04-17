import java.util.Arrays;

public class TrainApp {

    // UC20: Search with Exception Handling (Fail-Fast)
    public static boolean searchBogieWithValidation(String[] bogieIds, String searchKey) {

        // 🔴 Validation step (important)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // You can use Linear OR Binary search here (we'll use Binary for consistency)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(searchKey);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {}; // 🔴 try empty case
        String searchKey = "BG101";

        try {
            boolean found = searchBogieWithValidation(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie ID found.");
            } else {
                System.out.println("Bogie ID not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
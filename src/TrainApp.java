import java.util.Arrays;

public class TrainApp {

    // UC16: Bubble Sort Method
    public static void sortPassengerCapacities(int[] capacities) {
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    // Swap logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Example passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting: " + Arrays.toString(capacities));

        sortPassengerCapacities(capacities);

        System.out.println("After Sorting: " + Arrays.toString(capacities));
    }
}
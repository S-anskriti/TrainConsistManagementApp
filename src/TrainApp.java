import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        private String bogieId;
        private String bogieType;
        private int capacity;

        public Bogie(String bogieId, String bogieType, int capacity) {
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public String getBogieId() {
            return bogieId;
        }

        public String getBogieType() {
            return bogieType;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 72));
        bogies.add(new Bogie("B2", "AC Chair", 60));
        bogies.add(new Bogie("B3", "First Class", 80));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertEquals(2, result.size());
        assertEquals("B1", result.get(0).getBogieId());
        assertEquals("B3", result.get(1).getBogieId());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 70));
        bogies.add(new Bogie("B2", "AC Chair", 75));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("B2", result.get(0).getBogieId());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 50));
        bogies.add(new Bogie("B2", "AC Chair", 65));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 72));
        bogies.add(new Bogie("B2", "AC Chair", 75));
        bogies.add(new Bogie("B3", "First Class", 80));
        bogies.add(new Bogie("B4", "Sleeper", 55));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertEquals(3, result.size());
        assertEquals("B1", result.get(0).getBogieId());
        assertEquals("B2", result.get(1).getBogieId());
        assertEquals("B3", result.get(2).getBogieId());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 40));
        bogies.add(new Bogie("B2", "AC Chair", 50));
        bogies.add(new Bogie("B3", "First Class", 60));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 71));
        bogies.add(new Bogie("B2", "AC Chair", 75));
        bogies.add(new Bogie("B3", "First Class", 90));

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 72));
        bogies.add(new Bogie("B2", "AC Chair", 65));
        bogies.add(new Bogie("B3", "First Class", 80));

        int originalSize = bogies.size();
        String firstId = bogies.get(0).getBogieId();
        String secondId = bogies.get(1).getBogieId();
        String thirdId = bogies.get(2).getBogieId();

        List<Bogie> result = filterBogiesByCapacity(bogies, 70);

        assertEquals(2, result.size());

        assertEquals(originalSize, bogies.size());
        assertEquals(firstId, bogies.get(0).getBogieId());
        assertEquals(secondId, bogies.get(1).getBogieId());
        assertEquals(thirdId, bogies.get(2).getBogieId());
    }
}
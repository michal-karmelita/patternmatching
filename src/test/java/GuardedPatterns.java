import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuardedPatterns {

    @Test
    public void patternMatchingWithAdditionalIfTest() {
        assertEquals("A big car", switchVehicle(new Car(4000)));
        assertEquals("A car", switchVehicle(new Car(2000)));
    }

    private String switchVehicle(Vehicle vehicle) {
        String kindOfVehicle = null;
         switch (vehicle) {
            case null:
                break;
            case Car c:
                if (c.getWeight() > 3500) {
                    kindOfVehicle = "A big car";
                    break;// wewnątrz ifa
                }
                kindOfVehicle = "A car";
                break;
            default:
                kindOfVehicle =  "Another vehicle, can't be a small car";
        }
        return kindOfVehicle;
    }

    @Test
    public void patternMatchingSinglePatternTest() {
        assertEquals("A big car", switchVehicleSinglePattern(new Car(4000)));
        assertEquals("A car", switchVehicleSinglePattern(new Car(2000)));
    }

    private String switchVehicleSinglePattern(Vehicle vehicle) {
        return switch (vehicle) {
            case null -> null;
            case Car c && (c.getWeight() > 3500) -> "A big car";
            case Car c -> "A car";
            default -> "Another vehicle";
        };
    }


    class Vehicle {
    }

    class Car extends Vehicle {
        int weight;
        public Car(int weight) {
            this.weight = weight;
        }
        public int getWeight() {
            return weight;
        }
    }
}

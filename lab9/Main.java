import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 2023, 75);
        ElectricCar electricCar1 = new ElectricCar("Hyundai", "Ioniq 6", 2022, 74);
        ElectricCar electricCar2 = new ElectricCar("Rolls-Royce", "Spectre", 2023, 87);

        GasolineCar gasolineCar = new GasolineCar("Toyota", "Camry", 2023, 3.5);
        GasolineCar gasolineCar1 = new GasolineCar("Nissan", "Sentra", 2021, 2.5);
        GasolineCar gasolineCar2 = new GasolineCar("Kia", "Forte", 2022, 1.5);

        
        Comparator<Car> brandComparator = Comparator.comparing(Car::getBrand);

       
        Comparator<Car> reversedBrandComparator = brandComparator.reversed();

        Comparator<Car> brandThenYearComparator = Comparator.comparing(Car::getBrand).thenComparing(Car::getYear);

        
        Comparator<Car> nullsFirstBrandComparator = Comparator.nullsFirst(Comparator.comparing(Car::getBrand));

        
        Car[] carsArray = {electricCar, electricCar1, electricCar2, gasolineCar, gasolineCar1, gasolineCar2};

        
        Arrays.sort(carsArray, brandComparator);
        System.out.println("\nSorted cars array by brand (ascending):");
        for (Car car : carsArray) {
            System.out.println(car);
        }

        TreeSet<Car> carsSetSortedByBrand = new TreeSet<>(brandComparator);
        carsSetSortedByBrand.addAll(Arrays.asList(carsArray));

        System.out.println("\nCars TreeSet sorted by brand:");
        for (Car car : carsSetSortedByBrand) {
            System.out.println(car);
        }

        Arrays.sort(carsArray, reversedBrandComparator);
        System.out.println("\nSorted cars array by brand (descending):");
        for (Car car : carsArray) {
            System.out.println(car);
        }

        Arrays.sort(carsArray, brandThenYearComparator);
        System.out.println("\nSorted cars array by brand, then by year:");
        for (Car car : carsArray) {
            System.out.println(car);
        }

        Arrays.sort(carsArray, nullsFirstBrandComparator);
        System.out.println("\nSorted cars array with nulls first:");
        for (Car car : carsArray) {
            System.out.println(car);
        }
    }
}

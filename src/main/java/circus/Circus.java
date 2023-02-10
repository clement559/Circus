package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

        System.out.println("Number of animals: " + animals.length);
        makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        Duck donald = new Duck("Donald");
        animalArrayList.add(donald);
        Parrot caonima = new Parrot("caonima");
        animalArrayList.add(caonima);
        Elephant kanina = new Elephant("alamak");
        animalArrayList.add(kanina);

        printAllAnimals(animalArrayList);

        System.out.println("Number of animals: " + animalArrayList.size());

        System.out.println("caonima is at: " + animalArrayList.indexOf(caonima));

        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);

        animalArrayList.add(new Tiger("Sherkhan"));

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck();
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot();
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}

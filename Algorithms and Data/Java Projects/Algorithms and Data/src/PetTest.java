import java.util.Random;
import java.util.Scanner;

public class PetTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dog dog1 = new Dog("Skye", 7, "husky");
        Dog dog2 = new Dog("Luna", 4, "terrier");

        Cat cat1 = new Cat("Lola", 3, "siamese");
        Cat cat2 = new Cat("Kira", 11, "ragdoll");

        System.out.println(dog1.speak());
        System.out.println(dog2.speak());

        System.out.println(cat1.speak());
        System.out.println(cat2.speak());

        Pets[] pets = new Pets[5];
        String[] dogBreeds = {"husky", "terrier", "retriever", "poodle", "dachshund"};
        String[] catBreeds = {"siamese", "ragdoll", "sphynx", "persian", "shorthair"};

        Random random = new Random();
        int catCount = 0;
        int dogCount = 0;

        for (int i = 0; i < pets.length; i++) {
            System.out.println("Would you like to add a cat or dog to the list? (C/D): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            String breed;
            int age = random.nextInt(15) + 1;

            if (answer.equals("C")) {
                breed = catBreeds[random.nextInt(catBreeds.length)];
                System.out.println("Please enter the name of the cat: ");
                String catName = scanner.nextLine();
                pets[i] = new Cat(catName, age, breed);
                catCount++;
            }else if (answer.equals("D")) {
                breed = dogBreeds[random.nextInt(dogBreeds.length)];
                System.out.println("Please enter the name of the dog: ");
                String dogName = scanner.nextLine();
                pets[i] = new Dog(dogName, age, breed);
                dogCount++;
            }else {
                System.out.println("Incorrect choice, try again!");
                i--;
            }

            System.out.println("Total cats: " + catCount);
            System.out.println("Total dogs: " + dogCount);
        }
    }
}

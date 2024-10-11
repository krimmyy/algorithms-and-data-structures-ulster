package Week1;

public class Dog extends Pets {
    private String breed;

    // default constructor
    public Dog() {
        breed = "";
    }

    // overloaded constructor
    public Dog(String petName, int petAge, String petBreed) {
        super(petName, petAge);
        breed = petBreed;
    }

    // getters setters
    public String getBreed() {
        return breed;
    }

    public void setBreed(String petBreed) {
        breed = petBreed;
    }

    // speak method
    public String speak() {
        return "Woof! I am " + getName() + ", a " + getAge() + " year old " + getBreed() + ".";
    }
}

package Week1;

public class Cat extends Pets {
    private String breed;

    // default constructor
    public Cat() {
        breed = "";
    }

    // overloaded constructor
    public Cat(String petName, int petAge, String petBreed) {
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
        return "Meow! I am " + getName() + ", a " + getAge() + " year old " + getBreed()+ ".";
    }
}

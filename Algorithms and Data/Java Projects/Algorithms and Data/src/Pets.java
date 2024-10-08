public class Pets {
    // initalizing variables
    private String name;
    private int age;

    // default constructor
    public Pets() {
        name = "";
        age = 0;
    }

    // overloaded constructor
    public Pets(String petName, int petAge) {
        name = petName;
        age = petAge;
    }

    // toString
    public String toString() {
        return name + " is " + age + " years old";
    }

    // getters setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String petName) {
        name = petName;
    }

    public void setAge(int petAge) {
        age = petAge;
    }

}

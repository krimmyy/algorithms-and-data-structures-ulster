package Week2;

public class Lion extends Animal {
    private int numberOfLions;
    private int lionAge = 0;
    private String lionName = "";
    public static int noOfObjects = 0;

    public Lion() {
        numberOfLions = 0;
        noOfObjects++;
    }

    public Lion(String foodType, int lifeExpectancy, int age, String name) {
        super(foodType, lifeExpectancy);
        lionAge = age;
        lionName = name;
        noOfObjects++;
    }

    public String getName() {
        return lionName;
    }

    public int getAge() {
        return lionAge;
    }

    public void setName(String name) {
        lionName = name;
    }

    public void setAge(int age) {
        lionAge = age;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public int noOfLions() {
        return noOfObjects;
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        Lion myLion1 = new Lion("meat", 16, 12, "Simba");
        Lion myLion2 = new Lion();

        myLion1.setAge(3);
        System.out.println(myLion1);
        System.out.println(myLion2);
        System.out.println("There are " + Lion.noOfObjects + " lions.");
    }
}

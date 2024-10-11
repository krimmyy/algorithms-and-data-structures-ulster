package Week1;

public class BuildingTest {
    public static void main(String[] args) {

        Building building1 = new Building();
        Building building2 = new Building("27 Mills Road", "Jonny");
        Building building3 = new Building("75 Brald Street", "David");

        System.out.println(building2.toString());

        System.out.println(building3.getOwner() + " owns and lives in " + building3.getAddress());

        building3.setAddress("43 Trout Road");
        System.out.println(building3.toString());

        building2.setOwner("Thomas");
        System.out.println(building2.toString());

        House house1 = new House();
        House house2 = new House("43 Strand Street", "Jack",4, true);
        System.out.println(house2.toString());

        house2.setAddress("76 Hank Road");
        house2.setOwner("Jill");
        System.out.println(house2.toString());

        System.out.println(house2.getOwner() + " owns and lives in " + house2.getAddress());

        Shop shop1 = new Shop();
        Shop shop2 = new Shop("58 Brook Road", "Karen", 12, 32000);
        System.out.println(shop2.toString());


        shop2.setAddress("11 Langley Street");
        shop2.setOwner("Janet");
        System.out.println(shop2.toString());

        System.out.println(shop2.getOwner() + " owns and runs the shop at " + shop2.getAddress());



    }
}

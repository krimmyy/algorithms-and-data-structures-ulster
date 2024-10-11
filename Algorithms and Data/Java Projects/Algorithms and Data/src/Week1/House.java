package Week1;

public class House extends Building {
    private int numBedrooms;
    private boolean hasGarage;

    public House() {
        numBedrooms = 0;
        hasGarage = false;
    }

    public House(String add, String own, int beds, boolean garage) {
        super(add, own);
        numBedrooms = beds;
        hasGarage = garage;
    }

    public int getNumBedrooms(){
        return numBedrooms;
    }

    public boolean getHasGarage() {
        return hasGarage;
    }

    public void setNumBedrooms(int add) {
        numBedrooms = add;
    }

    public void setHasGarage(boolean add) {
        hasGarage = add;
    }
    // getters setters

    @Override
    public String toString() {
        return "Has " + numBedrooms + " bedrooms, " +
                hasGarage +" garages.";
    }
}

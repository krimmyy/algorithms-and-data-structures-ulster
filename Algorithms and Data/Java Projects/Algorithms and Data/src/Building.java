public class Building {
    private String address;
    private String owner;

    public Building() {
        address = "";
        owner = "";
    }

    public Building(String add, String own) {
        address = add;
        owner = own;
    }

    public String toString() {
        return address + " occupied by " + owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String add) {
        address = add;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String add) {
        owner = add;
    }
}

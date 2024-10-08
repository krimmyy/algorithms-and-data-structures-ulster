public class Shop extends Building {
    private int numEmployees;
    private int averageTurnover;

    public Shop() {
        numEmployees = 0;
        averageTurnover = 0;
    }

    public Shop(String add, String own, int employees, int turnover) {
        super(add, own);
        numEmployees = employees;
        averageTurnover = turnover;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public int getAverageTurnover() {
        return averageTurnover;
    }

    public void setNumEmployees(int add) {
        numEmployees = add;
    }

    public void setAverageTurnover(int add) {
        averageTurnover = add;
    }
    // getters setters


    @Override
    public String toString() {
        return "Has " + numEmployees + " employees," +
                "the average turnover is " + averageTurnover;
    }
}



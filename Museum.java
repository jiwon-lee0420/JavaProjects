public class Museum extends Attraction{
    private final int maxCapacity;
    private int occupancy;
    public Museum(String name, final double admissionFee, final int maxCapacity) {
        super(name, admissionFee);
        this.maxCapacity = maxCapacity;
        this.occupancy = 0;
    }
    public Museum(String name) {
        this(name, 5.25, 25);
    }
    public void admit(String[] names) {
        if (names.length > maxCapacity) {
            System.out.println("Museum has reached maximum capacity. Please visit another time!");
        } else {
            super.admit(names);
            this.occupancy += names.length;
        }
    }
    public void rateAndExit(int index, int rating) {
        if (this.visitors[index] == null || index < 0 || index > this.visitors.length) {
            System.out.println("Could not update rating. Index invalid.");
        } else {
            super.rateAndExit(index, rating);
            this.occupancy -= 5;
        }
    }
    public double percentOccupancy() {
        return Math.round((this.occupancy / this.maxCapacity) * 100) / 100.0;
    }
    public String toString() {
        return "Museum: " + this.name + "/" + this.averageRating() + "/" 
               + this.admissionFee + "/" + this.percentOccupancy() + "%";
    }
}

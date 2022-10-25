public class Attraction implements Admittable, Comparable{
    protected final String name;
    private long sumRatings;
    private int numRatings;
    protected final double admissionFee;
    protected Group[] visitors;
    public Attraction(String name, final double admissionFee) {
        this.name = name;
        this.admissionFee = admissionFee;
        this.sumRatings = 0;
        this.numRatings = 0;
        this.visitors = new Group[5];
    }
    public Attraction(String name) {
        this(name, 5.25);
    }
    public void admit(String[] names) {
        if(names.length / 5 > 5) {
            this.resize(names.length);
        }
        for (int i = 0; i < this.visitors.length; i++) {
            String[] group = new String[5];
            for (int j = 0; j < 5; j++) {
                group[j] = names[j];
            }
            this.visitors[i] = new Group(group);
            names = this.cut(names, 5);
        }
    }
    public void resize(int namesLength) {
        if (namesLength % 5 != 0) {
            this.visitors = new Group[namesLength / 5 + 1];
        } else {
            this.visitors = new Group[namesLength / 5];
        }
    }
    public String[] cut (String[] names, int cutLength) {
        String[] result = new String[names.length - cutLength];
        for (int i = 0; i < names.length - cutLength; i++) {
            result[i] = names[i + cutLength];
        }
        return result;
    }
    public void rateAndExit(int index, int rating) {
        if (this.visitors[index] == null || index < 0 || index > this.visitors.length) {
            System.out.println("Could not update rating. Index invalid.");
        } else {
            if (rating > 10) {
                rating = 10;
            } else if (rating < 0) {
                rating = 0;
            }
            this.sumRatings += rating;
            this.numRatings ++;
            this.visitors[index] = null;
            for (int i = rating + 1; i < visitors.length; i++) {
                if (this.visitors[i] == null) {
                    break;
                } else {
                    this.visitors[i - 1] = this.visitors[i];
                }
            }
        }
    }
    public double averageRating() {
        return Math.round((this.sumRatings / this.numRatings) * 100) / 100.0;
    }
    public void printVisitors() {
        System.out.println(this);
        for (int i = 0; i < this.visitors.length; i++) {
            System.out.println("Group " + i + ": " + this.visitors[i].toString());
        }

    }
    public String toString() {
        return this.name + "/" + this.averageRating() + "/" + this.admissionFee;
    }
    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Attraction) {
            Attraction o = (Attraction) obj;
            if (this.averageRating() == o.averageRating()) {
                if (this.admissionFee == o.admissionFee) {
                    return 0;
                } else if (this.admissionFee < o.admissionFee
                           && !this.equals(o)) {
                    return -1;
                } else if (this.admissionFee > o.admissionFee
                           && !this.equals(o)) {
                    return 1;
                }
            }
            if (this.averageRating() > o.averageRating()
                && !this.equals(o)) {
                return -1;
            } else if (this.averageRating() < o.averageRating()
                       && !this.equals(o)) {
                return 1;
            }
        }
        return -1;
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Attraction) {
            Attraction o = (Attraction) obj;
            return this.name.equals(o.name) 
                   && this.admissionFee == o.admissionFee
                   && this.sumRatings == o.sumRatings
                   && this.numRatings == o.numRatings
                   && this.visitors.length == o.visitors.length;
        } else {
            return false;
        }
    }
}


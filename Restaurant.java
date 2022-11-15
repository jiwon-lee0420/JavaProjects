public class Restaurant {
    /**
     * Uses merge sort in order to sort an array of SushiRoll
     * objectrs lexicographically by name.
     * @param sr the list of SushiRoll objects.
     * @return the ordered SushiRoll list.
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] sr) {
        if (sr.length == 1) {
            return sr;
        }
        SushiRoll[] fh = new SushiRoll[sr.length/2];
        for (int i = 0; i < fh.length; i++) {
            fh[i] = sr[i];
        }
        SushiRoll[] sh = new SushiRoll[sr.length - fh.length];
        for (int i = fh.length, j = 0; j < sh.length; i++, j++) {
            sh[j] = sr[i];
        }
        if (sr.length == 2) {
            return MergeHelper.merge(fh, sh);
        }
        fh = mergeSortRolls(fh);
        sh = mergeSortRolls(sh);
        return MergeHelper.merge(fh, sh);
    }
    /**
     * Merges different orders together into one list
     * that is ordered lexicographically.
     * @param orders a 2d array of SushiRoll objects
     * @return a 1d array of SushiRoll objects that are ordered.
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orders) {
        SushiRoll[] result = new SushiRoll[orders.length];
        if (orders.length == 2) {
            return MergeHelper.merge(orders[0], orders[1]);
        }
        SushiRoll[][] newOrders = new SushiRoll[orders.length -  1][orders[1].length];
        for (int i = 0, j = 1; i < newOrders.length; i++, j++) {
            newOrders[i] = orders[j];
        }
        return MergeHelper.merge(orders[0], mergeOrders(newOrders));
    }
    /**
     * Fix this.
     * @param sr
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] sr, String color) {
        SushiRoll[] result = new SushiRoll[sr.length];
        if (sr.length == 1) {
            if (sr[0].getColor().equals(color)) {
                return sr;
            } else {
                return null;
            }
        }
        SushiRoll[] newSR = new SushiRoll[sr.length - 1];
        for (int i = 0, j = 1; i < newSR.length; i++, j++) {
            newSR[i] = sr[j];
        }

        return result;
    }
    /**
     * Calculates the total price of the sushi rolls
     * in an order based on plate color.
     * @param sr
     * @return
     */
    public static double totalPrice(SushiRoll[] sr) {
        if (sr.length == 1) {
            String color = sr[0].getColor();
            if (color.equals("Red")) {
                return 7.0;
            } else if (color.equals("Green")) {
                return 6.5;
            } else if (color.equals("Blue")) {
                return 6.0;
            } else {
                return 6.5;
            }
        }
        SushiRoll[] newSR = new SushiRoll[sr.length - 1];
        for (int i = 0, j = 1; i < newSR.length; i++, j++) {
            newSR[i] = sr[j];
        }
        String color = sr[0].getColor();
        if (color.equals("Red")) {
            return 7.0 + totalPrice(newSR);
        } else if (color.equals("Green")) {
            return 6.5 + totalPrice(newSR);
        } else if (color.equals("Blue")) {
            return 6.0 + totalPrice(newSR);
        } else {
            return 6.5 + totalPrice(newSR);
        }
    }
    /**
     * start this.
     * @param sr
     */
    public static void flip(SushiRoll[] sr) {

    }
    public static void main(String[] args) {
        SushiRoll dragon = new SushiRoll("Dragon", "Green");
        SushiRoll california = new SushiRoll("California", "Blue");
        SushiRoll spider = new SushiRoll("Spider", "Red");
        SushiRoll tuna = new SushiRoll("Tuna", "Blue");
        SushiRoll salmon = new SushiRoll("Salmon", "Blue");
        SushiRoll volcano = new SushiRoll("Volcano", "Red");
        SushiRoll rainbow = new SushiRoll("Rainbow", "Green");
        SushiRoll shrimp = new SushiRoll("Shrimp", "Red");
        SushiRoll devils = new SushiRoll("Devils", "Red");
        SushiRoll boston = new SushiRoll("Boston", "Green");
        SushiRoll caterpillar = new SushiRoll("Caterpillar", "Blue");
        SushiRoll philly = new SushiRoll("Philly", "Green");
        SushiRoll cucumber = new SushiRoll("Cucumber", "Blue");
        SushiRoll phili = new SushiRoll("Philidelphia", "Blue");
        SushiRoll[] sr = {dragon, california, spider, tuna, salmon, volcano, rainbow, shrimp}; // 3 red, 2 green, 3 blue
        sr = mergeSortRolls(sr);
        System.out.println("----- SR -----");
        System.out.println("SR costs: " + totalPrice(sr));
        for (SushiRoll roll : sr) {
            System.out.println(roll);
        }
        SushiRoll[] sr1 = {devils, boston, caterpillar};
        sr1 = mergeSortRolls(sr1);
        System.out.println("----- SR1 -----");
        System.out.println("SR1 costs: " + totalPrice(sr1));
        for (SushiRoll roll : sr1) {
            System.out.println(roll);
        }
        SushiRoll[] sr2 = {philly, cucumber, phili};
        sr2 = mergeSortRolls(sr2);
        System.out.println("----- SR2 -----");
        System.out.println("SR2 costs: " + totalPrice(sr2));
        for (SushiRoll roll : sr2) {
            System.out.println(roll);
        }
        SushiRoll[][] orders = {sr, sr1, sr2};
        SushiRoll[] order = mergeOrders(orders);
        System.out.println("----- ORDERS -----");
        for (SushiRoll roll : order) {
            System.out.println(roll);
        }
    }
}
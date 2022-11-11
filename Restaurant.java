public class Restaurant {
    /**
     * finish this.
     * @param sr
     * @return
     */
    public SushiRoll[] mergeSortRolls(SushiRoll[] sr) {
        SushiRoll[] result = new SushiRoll[sr.length];
        SushiRoll[] fh = new SushiRoll[sr.length/2];
        for (int i = 0; i < fh.length; i++) {
            fh[i] = sr[i]; 
        }
        fh = mergeSortRolls(fh);
        SushiRoll[] sh = new SushiRoll[sr.length - fh.length];
        for (int i = fh.length, j = 0; j < sh.length; i++, j++) {
            sh[j] = sr[i];
        }
        sh = mergeSortRolls(sh);
        if (sr.length == 2) {
            return MergeHelper.merge(fh, sh);
        }
        for (int i = 0; i < fh.length; i++) {
            result[i] = fh[i];
        }
        for (int i = 0, j = fh.length; i < sh.length; i++, j++) {
            result[i] = sh[j];
        }
        return result;
    }
    /**
     * start this.
     * @param orders
     * @return
     */
    public SushiRoll[] mergeOrders(SushiRoll[][] orders) {

    }
    /**
     * Fix this.
     * @param sr
     */
    public SushiRoll[] platesOfColor(SushiRoll[] sr, String color) {
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
     * check this.
     * @param sr
     * @return
     */
    public double totalPrice(SushiRoll[] sr) {
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
    public void flip(SushiRoll[] sr) {

    }
}

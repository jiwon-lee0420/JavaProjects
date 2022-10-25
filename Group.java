public class Group {
    private final String[] people;
    public Group(final String[] people) {
        if (people == null) {
            this.people = new String[0];
        } else {
            this.people = new String[people.length];
            for (int i = 0; i < people.length; i++) {
                this.people[i] = people[i];
            }
        }
    }
    /**
     * Returns the amount of people in a Group object.
     * @return the length of people.
     */
    public int size() {
        return this.people.length;
    }
    @Override //FIX THIS!!!
    public String toString() {
        String names = "";
        for (int i = 0; i < this.people.length; i++) {
            names += this.people[i] + "/";
        }
        return names.substring(0, names.length() - 1);
    }
}

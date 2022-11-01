/**
 * An enum that holds the colors of RubberDuck object.
 * @author jlee3973
 * @version 1.0
 */
public enum Color {
    RED, GREEN, BLUE, YELLOW, MAGENTA, CYAN, BLACK, DARKGRAY, LIGHTGRAY, BROWN, BLONDE, WHITE;
    /**
     * returns color in lower case form.
     * @return color in lower case form.
     */
    public String toString() {
        return super.toString().toLowerCase();
    }
}
public class InvalidPartyMemberException extends Exception {
    public InvalidPartyMemberException(String message) {
        super(message);
    }
    public InvalidPartyMemberException() {
        super("Invalid party member!");
    }
}
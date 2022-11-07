public class QuestNotFoundException extends Exception {
    public QuestNotFoundException(String message) {
        super(message);
    }
    public QuestNotFoundException() {
        super("Selected Quest Not Found");
    }
}

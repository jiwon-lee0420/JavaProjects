public class FilmNotFoundException extends Exception{
    public FilmNotFoundException(String movie) {
        super(movie + " is not playing at this movie theater.");
    }
}

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The TrainIterator class is what allows the user to see if
 * there is a next in the linked list of Train Cars.
 * @author jlee3973
 * @version 1.0
 * @param <T> the generic that is used throughout the TrainIterator class.
 */
public class TrainIterator<T> implements Iterator<T> {
    private TrainCar<T> nextCar;
    /**
     * The constructor takes in a train object.
     * If train is null, then IllegalArgumentException is thrown.
     * Sets this.nextCar to the train's engine.
     * @param train the train that will be iterated through.
     */
    public TrainIterator(Train<T> train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null!");
        }
        this.nextCar = train.getEngine();
    }
    /**
     * Checks to see if the train has a car after the current car
     * that it is at.
     * @return t or f if there is a next car.
     */
    public boolean hasNext() {
        if (this.nextCar.getNextCar() == null) {
            return false;
        }
        return true;
    }
    /**
     * Returns the cargo of the next car. The first time
     * next() is used it returns the cargo of the first car, and
     * then so on and so forth.
     * @return the T cargo of the next train car.
     */
    public T next() {
        T cargo = this.nextCar.getCargo();
        if (this.hasNext()) {
            this.nextCar = this.nextCar.getNextCar();
        } else {
            throw new NoSuchElementException("There is no next car!");
        }
        return cargo;
    }
}
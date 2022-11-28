import java.util.Iterator;
import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;

public class TrainIterator<T> implements Iterator<T>{
    TrainCar<T> nextCar;
    public TrainIterator(Train<T> train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null!");
        }
        this.nextCar = train.getEngine();
    }
    public boolean hasNext() {
        if(this.nextCar.getNextCar() == null) {
            return false;
        }
        return true;
    }
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

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO JAVADOC
public class Train<T> implements List<T> {

    private TrainCar<T> engine;
    private int size;

    // TODO JAVADOC
    public Train() {
        engine = null;
        size = 0;
    }

    // TODO JAVADOC
    public Train(T[] cargoArray) {
        if (cargoArray == null) {
            throw new IllegalArgumentException("cargoArray cannot be null");
        }
        for (T cargo : cargoArray) {
            if (cargo == null) {
                throw new IllegalArgumentException("cargo cannot be null");
            }
            add(cargo); // keep adding to end
        }
    }

    // TODO JAVADOC
    public TrainCar<T> getEngine() {
        return engine;
    }

    // TODO JAVADOC
    public T[] toArray() {
        int count = 0;
        TrainIterator<T> iterator = new TrainIterator<T>(this);
        while (iterator.hasNext()) {
            count++;
            System.out.println(count);
        }
        T[] result = (T[]) new Object[count];
        iterator = new TrainIterator<T>(this);
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== TRAIN %d =====\nisEmpty: %s\nsize: %d\nengine: %s\nCHOO CHOO: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (engine == null ? "null" : engine.getCargo())));

        T[] cargo = toArray();
        if (cargo == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < cargo.length - 1; ++i) {
                sb.append(String.format("%s, ", cargo[i])); // append all but last value
            }
            if (cargo.length > 0) {
                sb.append(String.format("%s", cargo[cargo.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        TrainCar<T> last = this.engine;
        TrainIterator<T> iterator = new TrainIterator<T>(this);
        while (iterator.hasNext()) {
            last = last.getNextCar();
        }
        TrainCar<T> newCar = new TrainCar<T>(element);
        last.setNextCar(newCar);
        this.size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        TrainCar<T> last = this.engine;
        for (int i = 0; i < index; i++) {
            last = last.getNextCar();
        }
        TrainCar<T> temp = last.getNextCar();
        last.setNextCar(new TrainCar<T>(element, temp));
    }

    @Override
    public T remove() throws NoSuchElementException {
        return null; // FIXME
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        return null; // FIXME
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        return null; // FIXME
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        return null; // FIXME
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null; // FIXME
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        return false; // FIXME
    }

    @Override
    public void clear() {
        // FIXME
    }

    @Override
    public boolean isEmpty() {
        if (this.engine == null) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        TrainIterator<T> iterator = new TrainIterator<T>(this);
        while (iterator.hasNext()) {
            count++;
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return null; // FIXME
    }
}

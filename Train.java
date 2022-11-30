import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The Train class represents a train with train cars that hold cargo.
 * This class implements the given List interface.
 * @author jlee3973
 * @version 1.0
 * @param <T> the generic that is used throughout the Train class.
 */
public class Train<T> implements List<T> {
    private TrainCar<T> engine;
    private int size;
    /**
     * Default constructor that sets engine to null
     * and size to 0.
     */
    public Train() {
        engine = null;
        size = 0;
    }
    /**
     * Constructor of the train obect that takes in
     * an array of cargo, and creates a train with the
     * array of cargo.
     * @param cargoArray the array of cargo.
     */
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
    /**
     * Returns the engine of the train.
     * @return this.engine.
     */
    public TrainCar<T> getEngine() {
        return engine;
    }
    /**
     * Represents the train in form of an array
     * of the cargo.
     * @return an array of the cargo in order of the train.
     */
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
    /**
     * Returns the train in String form that
     * represents the train's cars and cargo.
     * @return the String form of the train.
     */
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

    /**
     * Inserts the element at the end of the list.
     *
     * @param element the element we are adding to the list.
     * @throws IllegalArgumentException if the passed in element is null.
     */
    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Passed in element is null.");
        }
        if (this.isEmpty()) {
            this.engine = new TrainCar<T>(element);
            this.size++;
        } else {
            TrainCar<T> last = this.engine;
            TrainIterator<T> iterator = new TrainIterator<T>(this);
            while (iterator.hasNext()) {
                last = last.getNextCar();
            }
            TrainCar<T> newCar = new TrainCar<T>(element);
            last.setNextCar(newCar);
            this.size++;
        }
    }

    /**
     * Inserts the element at the specified index of the list.
     * If an element exists at that index, the element in the list should come after the new element being added.
     *
     * @param index the index to add the element at.
     * @param element the element we are adding to the list.
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == size() is valid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException if the passed in element is null.
     */
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Passed in element is null.");
        }
        if (this.engine == null) {
            this.engine = new TrainCar<T>(element);
            this.size++;
        } else {
            TrainCar<T> last = this.engine;
            for (int i = 0; i < index; i++) {
                last = last.getNextCar();
            }
            TrainCar<T> temp = last.getNextCar();
            last.setNextCar(new TrainCar<T>(element, temp));
            this.size++;
        }
    }

    /**
     * Removes the element at the front of the list and returns it.
     *
     * @return the removed element from the front of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (this.engine == null) {
            throw new NoSuchElementException("There is no engine to remove.");
        } else if (this.size == 1) {
            this.engine = null;
            this.size--;
            return this.engine.getCargo();
        } else {
            T oldEngineCargo = this.engine.getCargo();
            this.engine = this.engine.getNextCar();
            this.size--;
            return oldEngineCargo;
        }
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index the index of the element to be removed.
     * @return the removed element at the specified index of the list.
     * @throws NoSuchElementException if the list is empty.
     * @throws IndexOutOfBoundsException if the passed in index is invalid.
     */
    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (this.engine == null) {
            throw new NoSuchElementException("There is no train car to remove.");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Cannot remove the train car at this index.");
        } else {
            TrainCar<T> previousRemovedCar = this.engine;
            for (int i = 0; i < index - 1; i++) {
                previousRemovedCar = previousRemovedCar.getNextCar();
            }
            TrainCar<T> removedCar = previousRemovedCar.getNextCar();
            previousRemovedCar.setNextCar(removedCar.getNextCar());
            this.size--;
            return removedCar.getCargo();
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list and returns it.
     *
     * @param element the element to be removed.
     * @return the element that is removed from the list. Do not return the passed in element!
     * @throws IllegalArgumentException if the passed in element is null.
     * @throws NoSuchElementException if the passed in element is not in the list.
     */
    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (this.engine == null) {
            throw new NoSuchElementException("There is no element to remove.");
        } else if (element == null) {
            throw new IllegalArgumentException("Passed in element is null");
        }
        int count = 0;
        TrainCar<T> checkCar = this.engine;
        while (!(checkCar.getCargo().equals(element))) {
            count++;
            checkCar = checkCar.getNextCar();
        }
        TrainCar<T> previousRemovedCar = this.engine;
        for (int i = 0; i < count - 1; i++) {
            previousRemovedCar = previousRemovedCar.getNextCar();
        }
        TrainCar<T> removedCar = previousRemovedCar.getNextCar();
        previousRemovedCar.setNextCar(removedCar.getNextCar());
        this.size--;
        return removedCar.getCargo();
    }
    /**
     * Replaces the element at a specific index with the passed in element.
     *
     * @param index the index of the element to be replaced.
     * @param element the element to replace the existing element at the passed in index with.
     * @return the element that was replaced.
     * @throws IndexOutOfBoundsException if the passed in index is invalid.
     *                                   In the event both arguments are invalid, this exception should be thrown.
     * @throws IllegalArgumentException if the passed in element is null.
     */
    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Passed in element is null.");
        }
        TrainCar<T> setCar = this.engine;
        for (int i = 0; i < index; i++) {
            setCar = setCar.getNextCar();
        }
        T oldCargo = setCar.getCargo();
        setCar.setCargo(element);
        return oldCargo;
    }
    /**
     * Returns the element at the specified index.
     * You must implement this method using an Iterator!
     *
     * @param index the index of the element to get
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the passed in index is invalid.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        TrainCar<T> getCar = this.engine;
        for (int i = 0; i < index; i++) {
            getCar.getNextCar();
        }
        return getCar.getCargo();
    }
    /**
     * Checks if the list contains a specific element.
     * You must implement this method using an Iterator!
     *
     * @param element the element to search for in the list.
     * @return whether the list contains the element.
     * @throws IllegalArgumentException if the passed in element is null.
     */
    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Passed in element is null.");
        }
        TrainCar<T> containCar = this.engine;
        for (int i = 0; i < this.size; i++) {
            if (containCar.getCargo().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        this.engine = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        if (this.engine == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
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
        return new TrainIterator<T>(this); // FIXME
    }
}
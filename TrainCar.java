/**
 * Represents a Train Car object which holds
 * cargo, and a node to the car after it.
 * @author jlee3973
 * @version 1.0
 * @param <T> the generic that is used throughout the TrainCar class.
 */
public class TrainCar<T> {
    private T cargo;
    private TrainCar<T> nextCar;
    /**
     * Constructor that takes in cargo and the next TrainCar object.
     * @param cargo the cargo of the car.
     * @param nextCar points to the next car.
     */
    public TrainCar(T cargo, TrainCar<T> nextCar) {
        this.cargo = cargo;
        this.nextCar = nextCar;
    }
    /**
     * Constructor that only takes in cargo and
     * defaults nextCar to null.
     * @param cargo the cargo of the car.
     */
    public TrainCar(T cargo) {
        this(cargo, null);
    }
    /**
     * Returns the cargo of the Train Car object.
     * @return this.cargo.
     */
    public T getCargo() {
        return this.cargo;
    }
    /**
     * Returns the next car of the Train Car object.
     * @return this.nextCar.
     */
    public TrainCar<T> getNextCar() {
        return this.nextCar;
    }
    /**
     * Allows user to set the cargo of the Train Car object
     * to something else.
     * @param newCargo the new cargo that cargo will be changed to.
     */
    public void setCargo(T newCargo) {
        this.cargo = newCargo;
    }
    /**
     * Allows user to change what car the Train Car points to
     * as its next car.
     * @param newNext the new next car that the Train Car object will point to.
     */
    public void setNextCar(TrainCar<T> newNext) {
        this.nextCar = newNext;
    }
}
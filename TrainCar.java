public class TrainCar<T> {
    private T cargo;
    private TrainCar<T> nextCar;

    public TrainCar(T cargo, TrainCar<T> nextCar) {
        this.cargo = cargo;
        this.nextCar = nextCar;
    }
    public TrainCar(T cargo) {
        this(cargo, null);
    }
    public T getCargo() {
        return this.cargo;
    }
    public TrainCar<T> getNextCar() {
        return this.nextCar;
    }
    public void setCargo(T newCargo) {
        this.cargo = newCargo;
    }
    public void setNextCar(TrainCar<T> newNext) {
        this.nextCar = newNext;
    }
}
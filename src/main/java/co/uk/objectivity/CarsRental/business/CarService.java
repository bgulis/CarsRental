package co.uk.objectivity.CarsRental.business;

import co.uk.objectivity.CarsRental.model.Cars;

import java.util.List;

public interface CarService {
    List<Cars> getAllCars();
    String getCarNameById(Integer id);
    Cars getCarById(Integer id);
    boolean deleteCarById(Integer id);
    String addCar(Cars car);
    Cars updateCarById(Cars car, Integer id);
    Integer getNextNumberId();
}

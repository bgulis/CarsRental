package co.uk.objectivity.CarsRental.business;

import co.uk.objectivity.CarsRental.model.Cars;

import java.util.List;

public interface CarService {
    List<Cars> getAllCars();
    String getCarNameById(Integer id);
    Cars getCarById(Integer id);
}

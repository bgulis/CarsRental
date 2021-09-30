package co.uk.objectivity.CarsRental.business;

import co.uk.objectivity.CarsRental.model.Cars;
import co.uk.objectivity.CarsRental.model.OperationStatus;
import co.uk.objectivity.CarsRental.model.Status;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class CarServiceImpl implements CarService {

    private List<Cars> cars = asList(
            new Cars(1,"Kia", Status.FREE_TO_USE, BigDecimal.valueOf(100)),
            new Cars(2,"Ford", Status.FREE_TO_USE,BigDecimal.valueOf(90)),
            new Cars(3,"Volvo", Status.IN_USE,BigDecimal.valueOf(210), Collections.singletonList("red, automatic, hybrid"))
    );

    @Override
    public List<Cars> getAllCars() {
        return cars;
    }

    @Override
    public String getCarNameById(Integer id) {
        return cars.stream()
                .filter(car -> Objects.equals(car.getId(id), id))
                .map(Cars::getCarModel)
                .findFirst().orElse(null);
    }

    @Override
    public Cars getCarById(Integer id) {
        return  cars.stream().filter(car-> Objects.equals(car.getId(id), id)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteCarById(Integer id) {
        return cars.remove(getCarById(id));
    }

    @Override
    public boolean updateCarById(Integer id) {
        return true;
    }

    @Override
    public boolean addCar(Cars car) {
        return cars.add(car);
    }


}

package co.uk.objectivity.CarsRental.business;

import co.uk.objectivity.CarsRental.model.Cars;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

//    private List<Cars> cars = asList(
//            new Cars(1,"Kia", Status.FREE_TO_USE, BigDecimal.valueOf(100)),
//            new Cars(2,"Ford", Status.FREE_TO_USE,BigDecimal.valueOf(90)),
//            new Cars(3,"Volvo", Status.IN_USE,BigDecimal.valueOf(210), Collections.singletonList("red, automatic, hybrid"))
//    );
    private List<Cars> cars = new ArrayList<>();

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
    public String updateCarById(Cars car, Integer id) {
        int idCars = id + 1;
        int indexList = id - 1;
        car.setId(idCars);
        cars.set(indexList, car);
        return "Car updated, id: " + id;
    }

    @Override
    public String addCar(Cars car) {
        Integer newId = getNextNumberId();
        car.setId(newId);
        cars.add(car);

        return "Car created, id: " +newId;
    }

    public Integer getNextNumberId(){
        return cars.size()+1;
    }


}

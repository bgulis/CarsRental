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
//        cars.add(new Cars(15,"Fiat", Status.IN_USE,BigDecimal.valueOf(10), Collections.singletonList("hybrid")));
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
    public Cars updateCarById(Cars car, Integer id) {

        return cars.set(id, car);
    }

    @Override
    public boolean addCar(Cars car) {
        car.setId(getNextNumberId());
        return cars.add(car);
    }

    public Integer getNextNumberId(){
        return cars.size();
    }


}

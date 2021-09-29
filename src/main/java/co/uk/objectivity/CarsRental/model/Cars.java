package co.uk.objectivity.CarsRental.model;

import java.math.BigDecimal;
import java.util.List;

public class Cars {
    private Integer id;
    private String carModel;
    private Status status;
    private BigDecimal price;
    private List<String> features;

    public Cars(Integer id, String carModel, Status status, BigDecimal price) {
        this.id = id;
        this.carModel = carModel;
        this.status = status;
        this.price = price;
    }

    public Cars(Integer id, String carModel, Status status, BigDecimal price, List<String> features) {
        this.id = id;
        this.carModel = carModel;
        this.status = status;
        this.price = price;
        this.features = features;
    }

    public Integer getId(Integer id) {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}

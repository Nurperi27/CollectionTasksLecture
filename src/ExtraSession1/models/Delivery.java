package ExtraSession1.models;

import ExtraSession1.enums.DeliveryStatus;

import java.time.LocalDate;

public class Delivery {
    private Long id;
    private String address;
    private LocalDate deliveryDate;
    private int price;
    private DeliveryStatus deliveryStatus;
    private Courier courier;
    private Package aPackage;

    public Delivery() {}

    public Delivery(Long id, String address, LocalDate deliveryDate, int price, DeliveryStatus deliveryStatus) {
        this.id = id;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
    }

    public Delivery(Long id, String address, LocalDate deliveryDate, int price, DeliveryStatus deliveryStatus, Courier courier, Package aPackage) {
        this.id = id;
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
        this.courier = courier;
        this.aPackage = aPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public String toString() {
        return "\nDelivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", deliveryStatus=" + deliveryStatus +
                ", courier=" + courier +
                ", aPackage=" + aPackage +
                '}';
    }
}

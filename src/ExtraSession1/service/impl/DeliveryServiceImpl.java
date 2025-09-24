package ExtraSession1.service.impl;

import ExtraSession1.db.Database;
import ExtraSession1.enums.DeliveryStatus;
import ExtraSession1.models.Courier;
import ExtraSession1.models.Delivery;
import ExtraSession1.service.DeliveryService;

import javax.management.RuntimeMBeanException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public String addDelivery(Delivery delivery) {
        Database.deliveryList.add(delivery);
        return "Delivery added!";
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return Database.deliveryList;
    }

    @Override
    public List<Delivery> getDeliveryByStatus(DeliveryStatus deliveryStatus) {
        try {
            boolean isblock = false;
            List<Delivery> deliveriesResult = new ArrayList<>();
            for (Delivery d : Database.deliveryList) {
                if (d.getDeliveryStatus().equals(deliveryStatus)) {
                    isblock = true;
                    deliveriesResult.add(d);
                }
            }
            if(!isblock) {
                throw new RuntimeException("Such delivery status not found!");
            }
            return deliveriesResult;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        try {
            for (Delivery d : Database.deliveryList) {
                if (d.getId().equals(id)) {
                    return d;
                }
            }
            throw new RuntimeException("Such id Delivery not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteDeliveryById(Long id) {
        try {
            for (Delivery d : Database.deliveryList) {
                if (d.getId().equals(id)) {
                    Database.deliveryList.remove(d);
                    return "Delivery is deleted!";
                }
            }
            throw new RuntimeException("Such id delivery not found!");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public Delivery getDeliveryByCourierId(Long idCourier) {
        try {
            for (Delivery d : Database.deliveryList) {
                if (d.getCourier().getId().equals(idCourier)) {
                    return d;
                }
            }
            throw new RuntimeException("Such id Courier not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateDeliveryStatus(Long id, DeliveryStatus newDeliveryStatus) {
        try {
            for (Delivery d : Database.deliveryList) {
                if (d.getId().equals(id)) {
                    d.setDeliveryStatus(newDeliveryStatus);
                    return "Delivery status updated!";
                }
            }
            throw new RuntimeException("Such id delivery not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public String assignCourierToDelivery(Long idDel, Long idCourier) {
        try {
            boolean isblock1 = false;
            boolean isblock2 = false;
            for (Delivery d : Database.deliveryList) {
                if (d.getId().equals(idDel)) {
                    isblock1 = true;
                    for (Courier c : Database.courierList) {
                        if (c.getId().equals(idCourier)) {
                            isblock2 = true;
                            d.setCourier(c);
                            return "Assigned!";
                        }
                    }
                    if (!isblock2) {
                        throw new RuntimeException("Such id Courier not found!");
                    }
                }
            }
            if (!isblock1) {
                throw new RuntimeException("Such id Delivery not found!");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

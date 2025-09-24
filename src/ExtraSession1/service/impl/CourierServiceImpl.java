package ExtraSession1.service.impl;

import ExtraSession1.db.Database;
import ExtraSession1.models.Courier;
import ExtraSession1.models.Delivery;
import ExtraSession1.service.CourierService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class CourierServiceImpl implements CourierService {
    @Override
    public String addCourier(Courier courier) {
        Database.courierList.add(courier);
        return "Courier is added!";
    }

    @Override
    public boolean getAvailableCourier(String nameCourier) {
        try {
            for (Courier c : Database.courierList) {
                if (c.getFullName().equals(nameCourier)) {
                    return c.getAvailable();
                }
            }
            throw new RuntimeException("Such Courier's full name not found!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Courier> getAvailableCouriers(boolean isTrue) {
        List<Courier> couriersAvailable = new ArrayList<>();
        try{
            boolean isblock = false;
            for(Courier c : Database.courierList){
                if(c.getAvailable() == isTrue){
                    isblock = true;
                    couriersAvailable.add(c);
                }
            }
            if(!isblock) {
                throw new RuntimeException("Such Couriers's available not found or the Available is empty!");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return couriersAvailable;
    }

    @Override
    public List<Courier> getAllCouriers() {
        return Database.courierList;
    }

    @Override
    public List<Courier> getCouriersByRating(double minRating) {
        List<Courier> couriersMinRating = new ArrayList<>();
        List<Courier> couriersMaxRating = new ArrayList<>();
        try {
            if(minRating > 5){
                for (Courier c1 : Database.courierList){
                    if(c1.getRating() > 5){
                        couriersMinRating.add(c1);
                    }
                }
                return couriersMinRating;
            } else if (minRating <= 5) {
                for(Courier c2 : Database.courierList){
                    if(c2.getRating() <= 5){
                        couriersMinRating.add(c2);
                    }
                }
                return couriersMinRating;
            }
        }catch (NumberFormatException e){
            System.out.println("Error: You didn't enter a integer number! " + e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCouriersStatus(Long id, Courier isAvailable) {
        boolean isblock = true;
        for (Courier c : Database.courierList) {
            if (c.getId().equals(id)) {
                c.setAvailable(isAvailable.getAvailable());
                return "Success changed Courier's status!";
            }
        }
        return "";
    }

    @Override
    public void setCourierRating(Long idCourier, double newRating) {
        boolean isblock = false;
        for(Courier c : Database.courierList){
            if(c.getId().equals(idCourier)){
                if(newRating > -10 && newRating < 10) {
                    isblock = true;
                    c.setRating(newRating);
                    System.out.println("Successfully setting Courier's Rating!");
                    break;
                }else throw new RuntimeException("Rating must be from -10 to 10!");
            }
        }
        if(!isblock) {
            throw new RuntimeException("Such courier's id not found!");
        }
    }
}

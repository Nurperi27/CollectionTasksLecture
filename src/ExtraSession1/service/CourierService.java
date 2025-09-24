package ExtraSession1.service;
import ExtraSession1.models.Courier;
import java.util.List;

public interface CourierService {
    String addCourier(Courier courier);
    boolean getAvailableCourier(String nameCourier);
    List<Courier> getAvailableCouriers(boolean isTrue);
    List<Courier> getAllCouriers();
    List<Courier> getCouriersByRating(double minRating);
    String updateCouriersStatus(Long id, Courier isAvailable);
    void setCourierRating(Long idCourier, double newRating);
}

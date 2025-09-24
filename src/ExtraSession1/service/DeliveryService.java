package ExtraSession1.service;

import ExtraSession1.enums.DeliveryStatus;
import ExtraSession1.models.Courier;
import ExtraSession1.models.Delivery;
import java.util.List;

public interface DeliveryService {
    String addDelivery(Delivery delivery);
    List<Delivery> getAllDeliveries();
    List<Delivery> getDeliveryByStatus(DeliveryStatus deliveryStatus);
    Delivery getDeliveryById(Long id);
    String deleteDeliveryById(Long id);
    Delivery getDeliveryByCourierId(Long idCourier);
    String updateDeliveryStatus(Long id, DeliveryStatus newDeliveryStatus);
    String assignCourierToDelivery(Long idDel, Long idCourier);
}

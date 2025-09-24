package ExtraSession1;

import ExtraSession1.db.Database;
import ExtraSession1.db.GenerateID;
import ExtraSession1.enums.DeliveryStatus;
import ExtraSession1.enums.PackageType;
import ExtraSession1.models.Courier;
import ExtraSession1.models.Delivery;
import ExtraSession1.models.Package;
import ExtraSession1.service.CourierService;
import ExtraSession1.service.DeliveryService;
import ExtraSession1.service.PackageService;
import ExtraSession1.service.impl.CourierServiceImpl;
import ExtraSession1.service.impl.DeliveryServiceImpl;
import ExtraSession1.service.impl.PackageServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        DeliveryService deliveryService = new DeliveryServiceImpl();
        CourierService courierService = new CourierServiceImpl();
        PackageService packageService = new PackageServiceImpl();
        boolean isRun = true;
        while(isRun) {
            while (true) {
                try {
                    System.out.println("""
                            \nSelect action:
                            1. Add Delivery
                            2. Get All Delivery
                            3. Get Delivery By Status 
                            4. Get Delivery By Id
                            5. Delete Delivery By Id
                            6. Update Delivery status
                            8. Get By Courier Id
                            9. Add Courier to DB-Courier
                            10. Get All Couriers
                            11. Get Available Courier
                            12. Get Available Couriers
                            7. Assign Courier to Delivery
                            13. Set Courier Rating
                            14. Get Couriers By Rating
                            15. Update Courier Status
                            16. Create Package
                            17. Assign Package to Delivery
                            18. Get All Packages
                            19. Sort Package By Type
                            20. Sort Package By Weight
                            21. Exit
                            """);
                    int action = scInt.nextInt();
                    switch (action) {
                        case 1: {
                            System.out.println("Add Delivery");
                            Delivery delivery = new Delivery();
                            delivery.setId(GenerateID.genDeliveryId());
                            System.out.println("Write address: ");
                            delivery.setAddress(sc.nextLine());
                            System.out.println("Write Date of Delivery");
                            delivery.setDeliveryDate(LocalDate.of(scInt.nextInt(), scInt.nextInt(), scInt.nextInt()));
                            System.out.println("Write price: ");
                            delivery.setPrice(scInt.nextInt());
                            System.out.println("Delivery status(WAITING, IN_TRANSIT, DELIVERED): ");
                            delivery.setDeliveryStatus(DeliveryStatus.WAITING);
                            System.out.println("Delivery Status: WAITING");
//                    String status = sc.nextLine();
//                    if (status.equalsIgnoreCase("WAITING")) {
//                        delivery.setDeliveryStatus(DeliveryStatus.WAITING);
//                    } else if (status.equalsIgnoreCase("IN_TRANSIT")) {
//                        delivery.setDeliveryStatus(DeliveryStatus.IN_TRANSIT);
//                    } else if (status.equalsIgnoreCase("DELIVERED")) {
//                        delivery.setDeliveryStatus(DeliveryStatus.DELIVERED);
//                    }
                            System.out.println(deliveryService.addDelivery(delivery));
                        }
                        break;
                        case 2:
                            System.out.println("Get All Delivery");
                            System.out.println(deliveryService.getAllDeliveries());
                            break;
                        case 3: {
                            System.out.println("Get Delivery By Status");
                            System.out.println("Delivery status(WAITING, IN_TRANSIT, DELIVERED): ");
                            String status = sc.nextLine();
                            if (status.equalsIgnoreCase("WAITING")) {
                                System.out.println(deliveryService.getDeliveryByStatus(DeliveryStatus.WAITING));
                            } else if (status.equalsIgnoreCase("IN_TRANSIT")) {
                                System.out.println(deliveryService.getDeliveryByStatus(DeliveryStatus.IN_TRANSIT));
                            } else if (status.equalsIgnoreCase("DELIVERED")) {
                                System.out.println(deliveryService.getDeliveryByStatus(DeliveryStatus.DELIVERED));
                            }
                        }
                        break;
                        case 4:
                            System.out.println("Get Delivery By Id");
                            System.out.println("Enter id Delivery: ");
                            Long idDel4 = scInt.nextLong();
                            if (idDel4 < 1) {
                                throw new RuntimeException("Id must not be less than 1!");
                            }
                            System.out.println(deliveryService.getDeliveryById(idDel4));
                            break;
                        case 5:
                            System.out.println("Delete Delivery By Id");
                            System.out.println("Enter id Delivery: ");
                            System.out.println(deliveryService.deleteDeliveryById(scInt.nextLong()));
                            break;
                        case 6: {
                            System.out.println("Update Delivery By Status");
                            System.out.println("Delivery id: ");
                            Long id4 = scInt.nextLong();
                            System.out.println("Delivery status(WAITING, IN_TRANSIT, DELIVERED): ");
                            String status4 = sc.nextLine();
                            if (status4.equalsIgnoreCase("WAITING")) {
                                System.out.println(deliveryService.updateDeliveryStatus(id4, DeliveryStatus.WAITING));
                            } else if (status4.equalsIgnoreCase("IN_TRANSIT")) {
                                System.out.println(deliveryService.updateDeliveryStatus(id4, DeliveryStatus.IN_TRANSIT));
                            } else if (status4.equalsIgnoreCase("DELIVERED")) {
                                System.out.println(deliveryService.updateDeliveryStatus(id4, DeliveryStatus.DELIVERED));
                            }
                        }
                        break;
                        case 7: {
                            System.out.println("Assign Courier To Delivery");
                            System.out.println("Write delivery id: ");
                            Long idDel7 = scInt.nextLong();
                            System.out.println("Write courier id: ");
                            Long idCour7 = scInt.nextLong();
                            System.out.println(deliveryService.assignCourierToDelivery(idDel7, idCour7));
                        }
                        break;
                        case 8: {
                            System.out.println("Get Delivery By Courier Id");
                            System.out.println("Write delivery id: ");
                            Long idCour8 = scInt.nextLong();
                            System.out.println(deliveryService.getDeliveryByCourierId(idCour8));
                        }
                        break;
                        case 9:
                            System.out.println("Add Courier");
                            Courier courier9 = new Courier();
                            courier9.setId(GenerateID.genCourierId());
                            System.out.println("Enter full name: ");
                            courier9.setFullName(sc.nextLine().trim());
                            System.out.println("Enter rating: ");
                            courier9.setRating(0);
                            System.out.println("Enter available is (true/false)");
                            String isAvailable9 = sc.nextLine();
                            if ("true".equalsIgnoreCase(isAvailable9)) {
                                courier9.setAvailable(true);
                            } else if ("false".equalsIgnoreCase(isAvailable9)) {
                                courier9.setAvailable(false);
                            }
                            System.out.println(courierService.addCourier(courier9));
                            break;
                        case 10:
                            System.out.println("Get All Couriers");
                            System.out.println(courierService.getAllCouriers());
                            break;
                        case 11:
                            System.out.println("Get Available Courier");
                            System.out.println("Enter Courier name to see his Available: ");
                            System.out.println(courierService.getAvailableCourier(sc.nextLine().trim()));
                            break;
                        case 12:
                            System.out.println("Get Available Couriers");
                            System.out.println("Enter 'Yes'(is Available) / 'Not'(is not Available)");
                            String isAvailable11 = sc.nextLine();
                            if ("yes".equalsIgnoreCase(isAvailable11)) {
                                System.out.println(courierService.getAvailableCouriers(true));
                            } else if ("not".equalsIgnoreCase(isAvailable11)) {
                                System.out.println(courierService.getAvailableCouriers(false));
                            }
                        /*else {
                            throw new RuntimeException("You should write only 'yes' or 'not'!");
                        }*/
                            break;
                        case 13:
                            System.out.println("Set Courier Rating");
                            Long idCourier13 = 0L;
                            try {
                                boolean isblock13 = true;
                                System.out.println("Enter Courier id to set rating: ");
                                idCourier13 = scInt.nextLong();
                                for (Courier c13 : Database.courierList) {
                                    if (!c13.getId().equals(idCourier13)) {
                                        isblock13 = false;
                                        throw new RuntimeException("Such courier's id not found!13");
                                        //break;
                                    }
                                }
                                if (!isblock13) {
                                    continue;
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                break;
                            }
                            System.out.println("Enter rating to Courier[-10; 10]");
                            double rating13 = scInt.nextDouble();
                            courierService.setCourierRating(idCourier13, rating13);
                            break;
                        case 14:
                            System.out.println("Get Couriers by Rating");
                            System.out.println("Enter rating (Max: more than 5 | Min: less than 5): ");
                            System.out.println(courierService.getCouriersByRating(scInt.nextDouble()));
                            break;
                        case 15:
                            System.out.println("Update Courier Status");
                            Courier courier15 = new Courier();
                            Long idCourier15 = 0L;
                            try {
                                boolean isblock15 = false;
                                System.out.println("Enter Courier id to update status: ");
                                idCourier15 = scInt.nextLong();
                                for (Courier c15 : Database.courierList) {
                                    if (c15.getId().equals(idCourier15)) {
                                        isblock15 = true;
                                        break;
                                    }
                                }
                                if (!isblock15) {
                                    throw new RuntimeException("Such courier's id not found!15");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                break;
                            }
                            System.out.println("Enter status of Courier(is / not): ");
                            String isAvailable15 = sc.nextLine();
                            if ("is".equalsIgnoreCase(isAvailable15)) {
                                courier15.setAvailable(true);
                            } else if ("not".equalsIgnoreCase(isAvailable15)) {
                                courier15.setAvailable(false);
                            }
                            System.out.println(courierService.updateCouriersStatus(idCourier15, courier15));
                            break;
                        case 16:
                            System.out.println("Create Package");
                            Package package16 = new Package();
                            package16.setId(GenerateID.genPackageId());
                            System.out.println("Enter weight of Package: ");
                            package16.setWeight(Double.parseDouble(sc.nextLine()));
                            System.out.println("Enter Type of Package(DOCUMENT, BOX, FOOD): ");
                            package16.setPackageType(PackageType.valueOf(sc.nextLine()));
                            System.out.println(packageService.createPackage(package16));
                            break;
                        case 17:
                            System.out.println("Assign Package to Delivery");
                            System.out.println("Write delivery id: ");
                            Long idDel17 = scInt.nextLong();
                            System.out.println("Write package id: ");
                            Long idPack17 = scInt.nextLong();
                            System.out.println(packageService.assignPackageToDeliveryById(idDel17, idPack17));
                            break;
                        case 18:
                            System.out.println("Get All Packages");
                            System.out.println(packageService.getAllPackages());
                            break;
                        case 19:
                            System.out.println("Sort Package by Type(a->z)");
                            System.out.println(packageService.sortPackageByType());
                            break;
                        case 20:
                            System.out.println("Sort Package by Weight( ... ->0)");
                            System.out.println(packageService.sortPackageByWeight());
                            break;
                        case 21: isRun = false;
                            System.out.println("Stop!");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
}

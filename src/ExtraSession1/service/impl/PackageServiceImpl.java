package ExtraSession1.service.impl;

import ExtraSession1.db.Database;
import ExtraSession1.models.Courier;
import ExtraSession1.models.Delivery;
import ExtraSession1.service.PackageService;
import ExtraSession1.models.Package;

import java.util.Comparator;
import java.util.List;

public class PackageServiceImpl implements PackageService {
    @Override
    public String createPackage(Package aPackage) {
        Database.packageList.add(aPackage);
        return "Package is added1!";
    }

    @Override
    public List<Package> getAllPackages() {
        return Database.packageList;
    }

    @Override
    public List<Package> sortPackageByType() {
        Database.packageList.sort(Comparator.comparing(t -> t.getPackageType().name()));
        //t -> t.getPackageType() - сортирует по списку(в каком порядке написаны перечисления) в enum - PackageType
        //t -> t.getPackageType().name() - по алфавиту
        Database.packageList.forEach(System.out::println);
        return Database.packageList;
    }

    @Override
    public List<Package> sortPackageByWeight() {
        Database.packageList.sort(Comparator.comparing(Package::getWeight).reversed());
        Database.packageList.forEach(System.out::println);
        return Database.packageList;
    }

    @Override
    public String assignPackageToDeliveryById(Long idDel, Long idPack) {
        try {
            boolean isblock1 = false;
            boolean isblock2 = false;
            for (Delivery d : Database.deliveryList) {
                if (d.getId().equals(idDel)) {
                    isblock1 = true;
                    for (Package p : Database.packageList) {
                        if (p.getId().equals(idPack)) {
                            isblock2 = true;
                            d.setaPackage(p);
                            return "Package is assigned!";
                        }
                    }
                    if (!isblock2) {
                        throw new RuntimeException("Such id Package not found!");
                    }
                }
            }
            if (!isblock1) {
                throw new RuntimeException("Such id Delivery not found!");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}

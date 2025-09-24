package ExtraSession1.service;

import ExtraSession1.models.Package;

import java.util.List;

public interface PackageService {
    String createPackage(Package aPackage);
    List<Package> getAllPackages();
    List<Package> sortPackageByType();
    List<Package> sortPackageByWeight();
    String assignPackageToDeliveryById(Long idDel, Long idPack);
}

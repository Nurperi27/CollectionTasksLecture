package ExtraSession1.models;

import ExtraSession1.enums.PackageType;

import java.util.Comparator;

public class Package {
    private Long id;
    private Double weight;
    private PackageType packageType;

    public Package() {
    }

    public Package(Long id, Double weight, PackageType packageType) {
        this.id = id;
        this.weight = weight;
        this.packageType = packageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }
    @Override
    public String toString() {
        return "\nPackage{" +
                "id=" + id +
                ", weight=" + weight +
                ", packageType=" + packageType +
                '}';
    }
}

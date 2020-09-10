package packages;

import interfaces.Package;
import lombok.Getter;
import models.PackageFeatures;



abstract class BasePackage implements Package {

    protected PackageFeatures packageFeatures;
    private int limit;
    private double price;
    private double onePrice;

    public BasePackage( int limit, double price) {
        this.limit = limit;
        this.price = price;
        packageFeatures = PackageFeatures.builder().limit(limit).price(price).build();
    }

    public BasePackage(int limit, double price, double onePrice) {
        this.limit = limit;
        this.price = price;
        this.onePrice = onePrice;
        packageFeatures = PackageFeatures.builder().limit(limit).price(price).build();
    }

    public double calculateAmount() {
        return 0;
    }

    public void increaseCount() {
        packageFeatures.setCount(packageFeatures.getCount()+1);
    }

    public void restart() {
        packageFeatures.setCount(0);
    }
}

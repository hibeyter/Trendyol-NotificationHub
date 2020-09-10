package packages;

import interfaces.Package;
import models.PackageFeatures;

public class SmsFlexible extends BasePackage implements Package {

    private final static int LIMIT =2000;
    private final static double PRICE =30;
    private final static double ONE_PRICE =0.10;
    private PackageFeatures packageFeatures;


    public SmsFlexible() {
        super(LIMIT, PRICE, ONE_PRICE);
        packageFeatures= super.packageFeatures;
    }

    public double calculateAmount() {
        if (packageFeatures.getCount()<= LIMIT)  return PRICE;
        return PRICE +((packageFeatures.getCount()- LIMIT)* ONE_PRICE);
    }

    @Override
    public void increaseCount() {
        super.increaseCount();
    }

    @Override
    public void restart() {
        super.restart();
    }
}

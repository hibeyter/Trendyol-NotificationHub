package packages;

import models.PackageFeatures;

public class EmailFlexible extends BasePackage {


    private final static int LIMIT =2000;
    private final static double PRICE =7.5;
    private final static double ONE_PRICE =0.03;
    private PackageFeatures packageFeatures;

    public EmailFlexible() {
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

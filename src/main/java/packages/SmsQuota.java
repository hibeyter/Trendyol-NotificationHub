package packages;



import models.PackageFeatures;


public class SmsQuota extends BasePackage {


    private PackageFeatures packageFeatures;
    private static final int LIMIT =1000;
    private static final double PRICE =20;

    public SmsQuota() {
        super(LIMIT, PRICE);
        packageFeatures=super.packageFeatures;
    }

    @Override
    public double calculateAmount() {
        return ((packageFeatures.getCount()/ LIMIT)+1)* PRICE;
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

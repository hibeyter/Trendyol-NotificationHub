package notifications;



import common.exceptions.CompanyHasNotAnyPackageException;
import common.exceptions.CompanyIsInBlackListException;
import common.languages.English;
import interfaces.*;
import interfaces.Package;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Company implements Sender {

    private String name;
    private String phone;
    private String email;
    private Package emailPackage;
    private Package smsPackage;
    private Language language;
    private Date startingDate;
    private List<Double> invoices;
    private boolean isInBlackList=false;


    public Company() {
        language = new English();//Default language
        startingDate=new Date();
        invoices=new ArrayList<Double>();
    }

    public void send(List<Channel> channels) {
        for (Channel channel : channels){
            if (isInBlackList)
                throw new CompanyIsInBlackListException(language.isInBlackList());
            channel.send();
        }
    }

    public void addInvoice(){
        if(isInBlackList) throw new CompanyIsInBlackListException(language.isInBlackList());

        invoices.add(calculateTotalAmount());
        newBillingCycle();
        if (invoices.size()>1) isInBlackList=true;
    }

    public void newBillingCycle(){
        if (emailPackage==null &&  smsPackage == null)
            throw new CompanyHasNotAnyPackageException(language.hasNotAnyPackage());
        if (emailPackage==null)  smsPackage.restart();
        else if (smsPackage==null)  smsPackage.restart();
        else{
            smsPackage.restart();
            emailPackage.restart();
        }
    }

    public double calculateTotalAmount() {
        if (emailPackage==null &&  smsPackage == null)
            throw new CompanyHasNotAnyPackageException(language.hasNotAnyPackage());
        if (emailPackage==null) return smsPackage.calculateAmount();
        if (smsPackage==null) return emailPackage.calculateAmount();
        return emailPackage.calculateAmount()+
               smsPackage.calculateAmount();
    }

    public void payInvoice() {
        if (!invoices.isEmpty()){
            invoices.remove(0);
            isInBlackList=false;
        }
    }


}

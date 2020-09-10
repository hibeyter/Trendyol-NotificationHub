package notifications;

import common.exceptions.CompanyHasNotAnyPackageException;
import common.exceptions.CompanyIsInBlackListException;
import interfaces.Channel;
import org.junit.Test;

import packages.EmailQuota;
import packages.SmsFlexible;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompanyTest {


    @Test(expected = CompanyHasNotAnyPackageException.class)
    public void it_should_company_has_not_any_package_exception(){
        Company company  = new Company();
        company.calculateTotalAmount();
    }

    @Test
    public void it_should_ten_price(){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());

        double price = company.calculateTotalAmount();

        assertEquals(10,price,0);
    }

    @Test
    public void it_should_forty_price(){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());
        company.setSmsPackage((new SmsFlexible()));

        double price = company.calculateTotalAmount();

        assertEquals(40.0,price,0);
    }

    @Test(expected = CompanyIsInBlackListException.class)
    public void it_should_company_is_in_blacklist_exception(){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());
        company.setSmsPackage((new SmsFlexible()));

        company.addInvoice();
        company.addInvoice();

        Email email = new Email();
        email.setBody("TEST");
        email.setSender(company);
        Email email1 = new Email();
        email1.setSender(company);
        email1.setBody("TEST");

        List<Channel> channels= new ArrayList();
        channels.add(email);
        channels.add(email1);

        company.send(channels);
    }

    @Test
    public void it_should_not_any_things(){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());
        company.setSmsPackage((new SmsFlexible()));

        company.addInvoice();


        Email email = new Email();
        email.setBody("TEST");
        email.setSender(company);
        Email email1 = new Email();
        email1.setSender(company);
        email1.setBody("TEST");

        List<Channel> channels= new ArrayList();
        channels.add(email);
        channels.add(email1);

        company.send(channels);
    }

    @Test(expected = CompanyIsInBlackListException.class)
    public void it_should_company_is_in_blacklist_exception_after_two_invoice(){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());
        company.setSmsPackage((new SmsFlexible()));
        company.addInvoice();
        company.addInvoice();
        company.addInvoice();
        company.addInvoice();
    }


    @Test
    public void it_should_payed (){
        Company company  = new Company();
        company.setEmailPackage(new EmailQuota());
        company.setSmsPackage((new SmsFlexible()));

        company.payInvoice();
    }




}

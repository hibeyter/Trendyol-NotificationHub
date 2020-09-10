


import common.languages.Turkish;
import interfaces.Channel;
import notifications.Company;
import notifications.Email;
import notifications.Sms;
import packages.EmailQuota;
import packages.SmsQuota;
import java.util.ArrayList;
import java.util.List;


public class main {

    public static void main(String[] args) {
        Company company = new Company();
        company.setName("Trendyol");
        company.setSmsPackage(new EmailQuota());
        company.setEmailPackage(new SmsQuota());
        company.setLanguage(new Turkish());

        Email email = new Email();
        Sms sms = new Sms();
        Email email1 = new Email();

        sms.setSender(company);


        email.setSender(company);
        email1.setSender(company);
        email1.setBody(null);


        List<Channel> list = new ArrayList<Channel>();
        list.add(email);
        list.add(sms);
        list.add(email1);


        for (int i = 1; i < 2002; i++) {
            try {
                sms.setBody("SMS " + i);
                email.setBody("EMAİL " + i);
                company.send(list);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Total =>" + company.calculateTotalAmount());
        /// Bir Ay geçti
        System.out.println("----------------------");
        company.addInvoice();
        System.out.println("Now Total =>" + company.calculateTotalAmount());

        for (int i = 0; i < 2; i++) {
            try {
                sms.setBody("SMS -- " + i);
                email.setBody("EMAİL -- " + i);
                company.send(list);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        /// Bir Ay geçti
        System.out.println("----------------------");
        company.addInvoice();
        System.out.println("Now Total =>" + company.calculateTotalAmount());

        try {
            sms.setBody("GİTME -- ");
            email.setBody("GİTME -- ");
            company.send(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company.payInvoice();

        try {
            sms.setBody("Git  -- ");
            email.setBody("GİT -- ");
            company.send(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /// Bir Ay geçti
        System.out.println("----------------------");
        company.addInvoice();
        System.out.println("Now Total =>" + company.calculateTotalAmount());


        try {
            sms.setBody("GİTME -- ");
            email.setBody("GİTME -- ");
            company.send(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}

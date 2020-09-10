package notifications;


import common.exceptions.CompanyHasNotThisPackageException;
import common.exceptions.NullBodyException;
import common.languages.English;
import org.junit.Test;
import packages.EmailFlexible;

public class EmailTest {

    @Test(expected = NullBodyException.class)
    public void it_should_exception(){
        Company company  = new Company();
        company.setEmailPackage(new EmailFlexible());
        company.setLanguage(new English());
        Email email= new Email();
        email.setSender(company);
        email.send();
    }

    @Test(expected = CompanyHasNotThisPackageException.class)
    public void it_should_company_has_not_this_package_exception(){
        Company company  = new Company();
        company.setLanguage(new English());
        Email email= new Email();
        email.setSender(company);
        email.setBody("TEST");
        email.send();
    }
}

package notifications;

import common.exceptions.CompanyHasNotThisPackageException;
import common.exceptions.NullBodyException;
import interfaces.Channel;
import lombok.Getter;
import lombok.Setter;
import models.User;

@Getter
@Setter
public class Sms implements Channel {

    private Company sender;
    private User receiver;
    private String body;

    public void send() {
        if (body==null) throw new NullBodyException(sender.getLanguage().nullBody());
        if (sender.getEmailPackage()==null)
            throw new CompanyHasNotThisPackageException(sender.getLanguage().hasNotThisPackage());
        sender.getSmsPackage().increaseCount();
        System.out.println(body);
    }

}

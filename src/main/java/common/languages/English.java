package common.languages;

import common.ErrorMessage;
import interfaces.Language;

public class English implements Language {
    public String isInBlackList() {
        return ErrorMessage.isInBlackListEN.getMessage();
    }

    public String hasNotAnyPackage() {
        return ErrorMessage.hasNoAnyPackageEN.getMessage();
    }

    public String nullBody() {
        return ErrorMessage.nullBodyEN.getMessage();
    }

    public String hasNotThisPackage() {
        return ErrorMessage.hasNoThisPackageEN.getMessage();
    }
}

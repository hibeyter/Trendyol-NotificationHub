package common.languages;

import common.ErrorMessage;
import interfaces.Language;

public class Turkish implements Language {
    public String isInBlackList() {
        return ErrorMessage.isInBlackListTR.getMessage();
    }

    public String hasNotAnyPackage() {
        return ErrorMessage.hasNoAnyPackageTR.getMessage();
    }

    public String nullBody() {
        return ErrorMessage.nullBodyTR.getMessage();
    }

    public String hasNotThisPackage() {
        return ErrorMessage.hasNoThisPackageTR.getMessage();
    }
}

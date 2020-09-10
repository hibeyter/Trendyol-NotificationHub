package common;

public enum ErrorMessage {
    isInBlackListTR("Firmanız kara listeye alınmış"),
    isInBlackListEN("Your company has been blacklisted"),
    hasNoAnyPackageTR("Firmanın herhangi bir paketi yok"),
    hasNoAnyPackageEN("The company has not any package"),
    hasNoThisPackageTR("Bu pakete sahip değilsin"),
    hasNoThisPackageEN("You don't have this package"),
    nullBodyTR("Boş içerik"),
    nullBodyEN("Empty content");

    String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }





}

package common.vo;

import springfox.documentation.service.Contact;

public class SwaggerApiInfo {

    public static String getPackageName() {
        return "persh.britsa";
    }

    public static String getPath() {
        return "/*";
    }

    public static String getTerms() {
        return "Restricted to use only by Persh Corp products";
    }

    public static Contact getContact() {
        return new Contact("Persh Corporation", null, "askregins@gmail.com");
    }

    public static String getLicense() {
        return "API License";
    }

    public static String getLicenseURL() {
        return null;
    }

}

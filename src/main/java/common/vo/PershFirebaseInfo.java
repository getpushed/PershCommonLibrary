package common.vo;

import common.exceptions.ApplicationException;

public class PershFirebaseInfo {

    private PershFirebaseInfo() {
    }

    public static String getRealTimeDBProdURL() throws ApplicationException {
        throw new ApplicationException(PershFirebaseInfo.class, "PROD URL currently unavailable!");
    }

    public static String getRealTimeDBTestURL() {
        return "https://smartproduct-test.firebaseio.com/";
    }

}

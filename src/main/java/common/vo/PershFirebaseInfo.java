package common.vo;

import common.exceptions.ApplicationException;

public class PershFirebaseInfo {

    private PershFirebaseInfo() {
    }

    public static String getRealTimeDBProdURL() {
        return "https://smartproduct-prod.firebaseio.com/";
    }

    public static String getRealTimeDBTestURL() {
        return "https://smartproduct-test.firebaseio.com/";
    }

}

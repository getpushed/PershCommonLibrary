/*
 *  ==============================================================================
 *
 *  Copyright 2020 Persh Corporation
 *  All rights reserved.
 *
 *  This program may not be duplicated, disclosed or provided to any third parties
 *  without the prior written consent of Persh Corporation.
 *
 *  Disassembly or de-compilation of the software and/or reverse engineering of
 *  the object code are prohibited.
 *
 *  ==============================================================================
 */

package common.vo;

import common.exceptions.AppResponse;
import common.exceptions.ApplicationException;
import common.exceptions.HTTPResponse;

import java.util.HashMap;
import java.util.Map;

public class SmartUtil {

    public static boolean validateId(String userIdentity) throws ApplicationException {

        String reg = "[a-zA-Z]{4}";
        String tester = "tester";
        if (userIdentity.matches(reg))
            return true;
        else if (userIdentity.matches(tester))
            return false;
        throw new ApplicationException(SmartUtil.class, AppResponse.INVALID_UID, HTTPResponse.INVALID_INPUT);
    }

    public static Map<String, String> provideDefaultServiceHeaders() {
        final String CONTENT_TYPE = "Content-Type";
        final String JSON_TYPE = "application/json";
        final String APPLICATION_ID = "APP-ID";
        final String AUTHORIZATION_ID = "AUTH-ID";

        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, JSON_TYPE);
        headers.put(APPLICATION_ID, "valid1token2here");
        headers.put(AUTHORIZATION_ID, "tester");
        return headers;
    }

}

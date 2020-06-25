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

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class SmartUtil {

    private SmartUtil() {}

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

    public static String phoneNumberToCustomerId(final Class<?> context, final String phoneNumber) {
        final String CUSTOMER_ID_PREFIX = "0x{0}";
        final String OUTPUT_LOG = "Phone Number {0} = Customer ID {1}";

        int recurrenceValue = 0x811c9dc5;
        final int length = phoneNumber.length();

        for (int iteration = 0; iteration < length; iteration++) {
            recurrenceValue ^= phoneNumber.charAt(iteration);
            recurrenceValue *= 0x01000193;
        }

        String hexString = Integer.toHexString(recurrenceValue);
        String customerId = MessageFormat.format(CUSTOMER_ID_PREFIX, hexString);

        SmartLogger.info(context, MessageFormat.format(OUTPUT_LOG, phoneNumber, customerId));
        return customerId;
    }

}

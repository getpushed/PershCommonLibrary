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

package common.exceptions;

public enum HTTPResponse {
    SUCCESS(200, "Success"),
    INVALID_INPUT(412, "Precondition failed"),
    INTERNAL_ERROR(500, "Internal error occurred in the application");

    private int httpErrorCode;
    private String httpErrorMessage;

    HTTPResponse(int code, String message) {
        this.httpErrorCode = code;
        this.httpErrorMessage = message;
    }

    public int getHttpErrorCode() {
        return httpErrorCode;
    }

    public String getHttpErrorMessage() {
        return httpErrorMessage;
    }
}


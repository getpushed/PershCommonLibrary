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

public enum AppResponse {
    INVALID_UID(7000, "Invalid user identity"),
    MESSAGE_ERROR(7001, "Messaging exception while sending an email"),
    DOCUMENT_ERROR(7002, "Document exception while writing the data into pdf"),
    ADDRESS_EXCEPTION(7003, "Address exception occurred"),
    FB_NOT_FOUND_FILE(7004, "Firebase credential file not found."),
    FB_IO_ERROR(7005, "Firebase I/O exception occured."),
    ;

    private int appErrorCode;
    private String appErrorMessage;

    AppResponse(int code, String message) {
        this.appErrorCode = code;
        this.appErrorMessage = message;
    }

    public int getAppErrorCode() {
        return appErrorCode;
    }

    public String getAppErrorMessage() {
        return appErrorMessage;
    }
}

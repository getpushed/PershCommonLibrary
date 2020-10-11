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

import common.dto.ResponseStatus;
import common.vo.SmartLogger;

public class ApplicationException extends Exception {

    private ResponseStatus responseStatus;

    public ApplicationException(Class<?> classType, String message) {
        super(message);
    }

    public ApplicationException(Class<?> classType, AppResponse appResponse, HTTPResponse httpResponse) {
        this.responseStatus = new ResponseStatus();

        this.responseStatus.setCode(httpResponse.getHttpErrorCode());
        this.responseStatus.setMessage(httpResponse.getHttpErrorMessage());

        SmartLogger.error(classType, appResponse);
    }

    /* should be removed after placing all local AppResponses */

    public ApplicationException(Class<?> classType, HTTPResponse httpResponse) {
        this.responseStatus = new ResponseStatus();

        this.responseStatus.setCode(httpResponse.getHttpErrorCode());
        this.responseStatus.setMessage(httpResponse.getHttpErrorMessage());
    }

    /* End of removal code */

    public ResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    public int getHttpStatus() {
        return this.responseStatus.getCode();
    }
}

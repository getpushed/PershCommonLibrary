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

    public ApplicationException(Class<?> classType, AppResponse appResponse, HTTPResponse httpResponse) {
        this.responseStatus = new ResponseStatus();

        this.responseStatus.setCode(httpResponse.getHttpErrorCode());
        this.responseStatus.setMessage(httpResponse.getHttpErrorMessage());

        SmartLogger.error(classType, appResponse);
    }

    public ResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    public int getHttpStatus() {
        return this.responseStatus.getCode();
    }
}

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

package common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.exceptions.HTTPResponse;

public class CommonResponse {

    @JsonProperty("response_status")
    protected ResponseStatus responseStatus;

    protected void setSuccessResponseStatus() {
        this.responseStatus = new ResponseStatus();
        this.responseStatus.setCode(HTTPResponse.SUCCESS.getHttpErrorCode());
        this.responseStatus.setMessage(HTTPResponse.SUCCESS.getHttpErrorMessage());
    }

}

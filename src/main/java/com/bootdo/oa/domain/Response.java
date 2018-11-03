package com.bootdo.oa.domain;

/**
 * <p>Title: Response</p>
 * <p>Description: Response</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class Response {

    private String responseMessage;

    public Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}

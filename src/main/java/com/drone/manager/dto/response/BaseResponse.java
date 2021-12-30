package com.drone.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    /**
     * HTTP status code
     */
    private String status;

    /**
     * HTTP Response Message
     */
    private String message;

    /**
     * Generic / complex response type
     */
    private T data;

    /**
     * @param status
     */
    public BaseResponse(String status) {
        this.status = status;
    }

    /**
     * @param status
     * @param message
     */
    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * @param status
     * @param message
     * @param result
     */
    public BaseResponse(String status, String message, T result) {
        this.status = status;
        this.message = message;
        this.data = result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
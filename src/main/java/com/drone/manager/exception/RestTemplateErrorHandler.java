package com.drone.manager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Slf4j
public class RestTemplateErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // your error handling here
        log.error("response code: {}", response.getRawStatusCode());
        log.error(response.getStatusText());

        throw new AccessDeniedException("Invalid Username/Password");
    }
}

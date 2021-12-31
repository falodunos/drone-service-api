package com.drone.manager.service.util;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppConstants {

    public static final String APP_CONTEXT = "/drone/api/v1/";

    public interface ApiResponseMessage {

        String SUCCESSFUL = "Successfully processed";
        String FAILED = "Failed request";
        String UPDATE = "Successfully updated";
        String GET = "Successfully fetched records";


    }
}

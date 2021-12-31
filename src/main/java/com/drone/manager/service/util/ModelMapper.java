package com.drone.manager.service.util;

import com.drone.manager.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@SuppressWarnings({"unchecked", "rawtypes"})
@Component
public class ModelMapper {

    @Autowired
    private AppConfig appConfig;

}

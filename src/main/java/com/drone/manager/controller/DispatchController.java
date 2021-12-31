package com.drone.manager.controller;

import com.drone.manager.config.AppConfig;
import com.drone.manager.dto.response.BaseResponse;
import com.drone.manager.service.util.LoggerService;
import com.drone.manager.service.util.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drone.manager.service.util.AppConstants;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@SuppressWarnings({"unchecked", "rawtypes"})
@RestController
@RequestMapping(value = AppConstants.APP_CONTEXT)
@Slf4j
public class DispatchController {

    @Autowired
    LoggerService loggerService;

    @Autowired
    AppConfig appConfig;

    @Autowired
    ModelMapper modelMapper;


    private static final Logger logger = LoggerFactory.getLogger(DispatchController.class);

    /**
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/register")
    public ResponseEntity<BaseResponse> getProducts(@Valid @RequestBody String request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }

    /**
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/loadItems")
    public ResponseEntity<BaseResponse> loadItems(@Valid @RequestBody String request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }

    /**
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/getDroneByLoadedItem")
    public ResponseEntity<BaseResponse> getDroneByLoadedItem(@Valid @RequestBody String request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }

    /**
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/listAvailableDrones")
    public ResponseEntity<BaseResponse> listAvailableDrones(@Valid @RequestBody String request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }

    /**
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/checkBatteryLevel")
    public ResponseEntity<BaseResponse> checkBatteryLevel(@Valid @RequestBody String request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }
}

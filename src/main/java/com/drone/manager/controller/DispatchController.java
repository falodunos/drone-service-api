package com.drone.manager.controller;

import com.drone.manager.config.AppConfig;
import com.drone.manager.dto.request.DroneDataDTO;
import com.drone.manager.dto.request.GenerateCodeDTO;
import com.drone.manager.dto.request.LoadItemDTO;
import com.drone.manager.dto.request.MedicationDataDTO;
import com.drone.manager.dto.response.BaseResponse;
import com.drone.manager.model.enums.CharCase;
import com.drone.manager.service.util.LoggerService;
import com.drone.manager.service.util.ModelMapper;
import com.drone.manager.service.util.code.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drone.manager.service.util.AppConstants;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;

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

    @Autowired
    CodeGenerator codeGenerator;


    private static final Logger logger = LoggerFactory.getLogger(DispatchController.class);

    /**
     * Registering a drone;
     *
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "drone/register")
    public ResponseEntity<BaseResponse> registerDrone(@Valid @RequestBody DroneDataDTO.Request.Body request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        logger.info(":: Drone Registration Request :: {}", request.toString());


        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }


    /**
     * Register a medication
     *
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "medication/register")
    public ResponseEntity<BaseResponse> registerMedication(@Valid @RequestBody MedicationDataDTO.Request.Body request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }

    /**
     * Generate a medication code
     *
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "medication/generate/code")
    public ResponseEntity<BaseResponse> generateMedicationCode(@Valid @RequestBody GenerateCodeDTO.Request.Body request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;
        ArrayList<String> codes = new ArrayList<>();
        for (int i = 0; i < request.getCodeCount(); i++)
            codes.add(codeGenerator.generate(CharCase.UPPER_CASE, request.getCodeLength()));
        return ResponseEntity.ok().body(new BaseResponse("200","success", codes));
    }

    /**
     * loading a drone with medication items;
     *
     * @param request
     * @param ucBuilder
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping(path = "/drone/load/items")
    public ResponseEntity<BaseResponse> loadItems(@Valid @RequestBody LoadItemDTO.Request.Body request, UriComponentsBuilder ucBuilder) throws Exception {

        BaseResponse response;

        return ResponseEntity.ok().body(new BaseResponse("", ""));
    }


    /**
     * checking loaded medication items for a given drone;
     *
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
     * checking available drones for loading;
     *
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
     * check drone battery level for a given drone;
     *
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

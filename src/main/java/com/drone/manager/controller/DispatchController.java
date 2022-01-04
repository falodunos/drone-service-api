package com.drone.manager.controller;

import com.drone.manager.config.AppConfig;
import com.drone.manager.dto.request.*;
import com.drone.manager.dto.response.BaseResponse;
import com.drone.manager.dto.response.UploadFileResponse;
import com.drone.manager.exception.DuplicateUniqueIdException;
import com.drone.manager.model.Drone;
import com.drone.manager.model.Medication;
import com.drone.manager.model.enums.CharCase;
import com.drone.manager.service.DroneService;
import com.drone.manager.service.FileStorageService;
import com.drone.manager.service.MedicationService;
import com.drone.manager.service.TransactionService;
import com.drone.manager.service.util.LoggerService;
import com.drone.manager.service.util.ModelMapper;
import com.drone.manager.service.util.code.CodeGenerator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drone.manager.service.util.AppConstants;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    DroneService droneService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    MedicationService medicationService;


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

        logger.info(":: Drone Registration Request :: {}", request.toString());

        BaseResponse response;
        Optional<Drone> optionalDrone = droneService.save(request);

        if (optionalDrone.isPresent()) {
            String drone = new Gson().toJson(optionalDrone.get());
            response = new BaseResponse(HttpStatus.CREATED.value() + "", "Saved Successfully", drone);
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.unprocessableEntity().body(new BaseResponse("500", "Unknown Error Occurred"));
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

        logger.info(":: Medication Registration Request :: {}", request.toString());

        BaseResponse response;
        Optional<Medication> optionalMedication = medicationService.save(request);

        if (optionalMedication.isPresent()) {
            String medication = new Gson().toJson(optionalMedication.get());
            response = new BaseResponse(HttpStatus.CREATED.value() + "", "Saved Successfully", medication);
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.unprocessableEntity().body(new BaseResponse("500", "Unknown Error Occurred"));
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
    @PostMapping(path = "drone/load/items")
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
    @PostMapping(path = "drone/load/byItem")
    public ResponseEntity<BaseResponse> getDroneByLoadedItem(@Valid @RequestBody GetDroneByItemDTO.Request.Body request, UriComponentsBuilder ucBuilder) throws Exception {

        if (request.getPackageReference().equalsIgnoreCase(request.getMedicationCode()))
            throw new DuplicateUniqueIdException("Duplicate! Package reference and medication code must be different ...");

        BaseResponse response;

        Drone drone = transactionService.getDroneByLoadedItem(request);
        String droneStr = new Gson().toJson(drone);
        response = new BaseResponse(HttpStatus.OK.value() + "", "Successful", droneStr);

        return ResponseEntity.ok().body(response);
    }

    /**
     * checking available drones for loading;
     *
     * @return ResponseEntity
     * @throws Exception
     */
    @GetMapping(path = "drone/list/available")
    public ResponseEntity<BaseResponse> listAvailableDrones() throws Exception {

        BaseResponse response;
        List<Drone> droneList = droneService.findAvailableDrones();
        String message = droneList.size() == 0? "No available drone" : "Successful";
        response = new BaseResponse("200", message, droneList);

        return ResponseEntity.ok().body(response);
    }


    /**
     * check drone battery level for a given drone;
     *
     * @param serialNumber
     * @return ResponseEntity
     * @throws Exception
     */
    @GetMapping(path = "/drone/battery/level/{sn}")
    public ResponseEntity<BaseResponse> checkBatteryLevel(@PathVariable(value = "sn") String serialNumber) throws Exception {

        BaseResponse response;
        boolean isValid = serialNumber.matches("^[A-Z0-9_]*$");
        if (!isValid) {
            return ResponseEntity.ok().body(new BaseResponse(HttpStatus.BAD_REQUEST.value() + "", "Serial number must contain only uppercase letters, underscore (_) and numbers"));
        }

        double batteryLevel = droneService.getDroneBatteryLevel(serialNumber);
        JsonObject responseObject = new JsonObject();
        responseObject.addProperty("batteryLevel", batteryLevel);

        return ResponseEntity.ok().body(new BaseResponse(HttpStatus.OK.toString(), "Successful", responseObject.toString()));
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
}

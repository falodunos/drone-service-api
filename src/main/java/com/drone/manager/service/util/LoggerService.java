package com.drone.manager.service.util;

import com.drone.manager.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({ "rawtypes"})
@Service
@Slf4j
public class LoggerService {

    @Autowired
    DroneRepository droneRepository;


//    /**
//     * @param request
//     * @param response
//     * @param merchant
//     */
//    public void logTransaction(DTO.Request.Body request, BaseResponse response, Merchant merchant) {
//        Transaction transaction = Transaction.getInstance();
//
//
//        transactionRepository.save(transaction);
//    }

}

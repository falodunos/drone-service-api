package com.drone.manager.service;


import com.drone.manager.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService extends BaseService {
    @Autowired
    TransactionRepository transactionRepository;

}

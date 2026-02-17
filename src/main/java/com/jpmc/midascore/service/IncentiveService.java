package com.jpmc.midascore.service;

import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IncentiveService {

    private static final Logger logger = LoggerFactory.getLogger(IncentiveService.class);
    private static final String INCENTIVE_API_URL = "http://localhost:8080/incentive";

    private final RestTemplate restTemplate;

    public IncentiveService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public float getIncentive(Transaction transaction) {
        try {
            Incentive incentive = restTemplate.postForObject(INCENTIVE_API_URL, transaction, Incentive.class);
            if (incentive != null) {
                logger.info("Received incentive: {} for transaction: {} -> {}", 
                           incentive.getAmount(), transaction.getSenderId(), transaction.getRecipientId());
                return incentive.getAmount();
            }
            logger.warn("Received null incentive response");
            return 0.0f;
        } catch (Exception e) {
            logger.error("Error calling incentive API: {}", e.getMessage());
            return 0.0f;
        }
    }
}

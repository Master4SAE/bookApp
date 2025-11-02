package com.mybooklistApp.bookApp.run;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunJsonDataLoder implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoder.class);
    private final RunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoder(RunRepository runRepository, ObjectMapper objectMapper){
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        if(runRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")){
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                log.info("Reading {} runs from JSON data and saving to in-memory collection.", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());
            } catch (IOException e){
                throw new RuntimeException("Failed to read json data", e);
            }
        } else {
            log.info("Not loding Runs from json data because the collection contains data. ");
        }
    }
    
}

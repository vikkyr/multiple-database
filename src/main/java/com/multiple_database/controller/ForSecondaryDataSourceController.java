package com.multiple_database.controller;


import com.multiple_database.serviceImpl.PersonServiceImplWithSecondaryDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ForSecondaryDataSourceController {
    @Autowired
    private PersonServiceImplWithSecondaryDatabase databaseImpl;

    @GetMapping("/secondary/test1")
    public String getTest(){
        log.info("ForPrimaryDataSourceController getTest Started");
        databaseImpl.test1();
        log.info("ForPrimaryDataSourceController getTest Ended");
        return "getTest";
    }

}

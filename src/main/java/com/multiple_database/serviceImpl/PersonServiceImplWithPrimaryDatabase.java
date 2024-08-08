package com.multiple_database.serviceImpl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonServiceImplWithPrimaryDatabase {


    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplateP;

    public void test1(){
        log.info("jdbcTemplateP=========>{}", jdbcTemplateP);
        log.info("jdbcTemplateP=========>{}", jdbcTemplateP.getMaxRows());
    }
}

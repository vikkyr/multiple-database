package com.multiple_database.serviceImpl;


import com.multiple_database.entity.Person;
import com.multiple_database.springDataJPA.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonServiceImplWithSecondaryDatabase {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplateS;

    @Autowired
    private PersonRepository personRepository;

    public void test1(){
        log.info("jdbcTemplateS=========>{}", jdbcTemplateS);
        log.info("jdbcTemplateS=========>{}", jdbcTemplateS.getMaxRows());
        Iterable<Person> all = personRepository.findAll();
        all.forEach(person -> {
            log.info("jdbcTemplateS person=========>{}", person);
        });

    }
}

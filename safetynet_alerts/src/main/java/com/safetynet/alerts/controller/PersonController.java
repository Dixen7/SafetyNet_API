package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.safetynet.alerts.service.PersonService;
import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public List<Person> addPerson(@RequestBody Person person) {
        List<Person> response = personService.add(person);
        logger.info("person : add( "+ person +" )");
        return response;
    }

    @PutMapping("/update")
    public List<Person> updatePerson(@RequestBody Person person) {
        List<Person> response = personService.update(person);
        logger.info("person : update( "+ person +" )");
        return response;
    }

    @DeleteMapping("/delete")
    public List<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        List<Person> response = personService.delete(firstName, lastName);
        logger.info("person : delete( "+ firstName +", " + lastName + ")");
        return response;
    }
}

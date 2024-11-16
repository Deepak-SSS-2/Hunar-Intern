package com.example.Helpdesk.api;

import com.example.Helpdesk.model.Person;
import com.example.Helpdesk.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@NonNull @PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id")UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }

    @PutMapping(path = "{id}/updateAdminMsg")
    public void updateAdminMsg(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updateAdminMsg(id, personToUpdate);
    }

    @PutMapping(path = "{id}/updateUserMsg")
    public void updateUserMsg(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updateUserMsg(id, personToUpdate);
    }
}

package com.example.Helpdesk.service;

import com.example.Helpdesk.dao.PersonDao;
import com.example.Helpdesk.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //or use @Component
public class PersonService {

    private final PersonDao personDao;

    //or use @Autowired
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

    public int updateUserMsg(UUID id, Person newperson){
        return personDao.updateUserMsgById(id, newperson);
    }

    public int updateAdminMsg(UUID id, Person newPerson){
        return personDao.updateAdminMsgById(id, newPerson);
    }

}

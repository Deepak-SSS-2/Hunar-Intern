package com.example.Helpdesk.dao;

import com.example.Helpdesk.model.Msg;
import com.example.Helpdesk.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao") //or use @Component("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(),"",new ArrayList<>(), new ArrayList<>()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate,new Person(id, update.getName(),"",new ArrayList<>(), new ArrayList<>()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updateUserMsgById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToUpdate = DB.indexOf(person1);
                    if (indexOfPersonToUpdate >=0 ){

                        ArrayList<Msg> userMsg = person1.getUserMsg();
                        userMsg.add(new Msg(update.getTempMsg(), LocalDateTime.now()));

                        DB.set(indexOfPersonToUpdate, new Person(id, person1.getName(),"", userMsg, person1.getAdminMsg()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updateAdminMsgById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person2 -> {
                    int indexOfPersonToUpdate = DB.indexOf(person2);
                    if (indexOfPersonToUpdate >=0 ){

                        ArrayList<Msg> adminMsg = person2.getAdminMsg();
                        adminMsg.add(new Msg(update.getTempMsg(), LocalDateTime.now()));

                        DB.set(indexOfPersonToUpdate, new Person(id, person2.getName(),"", person2.getUserMsg(),adminMsg));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}

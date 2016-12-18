package com.example.service;

import com.example.dao.PersonDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/12/15 16:04.
 */

@Service
@Transactional(transactionManager = "transactionManager",propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = { Exception.class })
public class PersonService {

    @Autowired
    private PersonDao personDao;


    public int savePserson(Person person){
        int i1 = personDao.savePerson(person);
        int i2 = personDao.savePerson2(person);
        return i1 + i2;

    }
    @Transactional(transactionManager = "transactionManager",readOnly = true)
    public List<Person> getAllPersonList(){

        List<Person> list =  personDao.getAllPersonList();
        List<Person> list2 =  personDao.getAllPersonList2();
        list.addAll(list2);
        return list;
    }


}

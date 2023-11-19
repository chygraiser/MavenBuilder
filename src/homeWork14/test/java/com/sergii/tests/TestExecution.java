package com.sergii.tests;

import com.sergii.code.Main;
import com.sergii.code.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestExecution {

    private static final Logger log = LogManager.getLogger(TestExecution.class);

    @BeforeEach
    public void beforeTest() {
        log.info("Smoke Test was started");
    }
    @Test
    public void checkSortByAge() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Lionel", "Messi", 32));
        userList.add(new User("Pele", "Pele", 88));
        userList.add(new User("Diego", "Maradona", 64));
        userList.add(new User("Cristiano", "Ronaldo", 33));
        userList.add(new User("Johan", "Cruyff", 57));
        userList.add(new User("Zinedine", "Zidane", 48));
        userList.add(new User("Gerd", "Muller", 62));
        userList.add(new User("Ronaldo", "Nazario", 46));
        userList.add(new User("Alfredo", "Stefano", 50));
        userList.add(new User("Michel", "Platini", 72));

        log.info("List of users was created");

        List<User> sortedByAge = Main.sortByAge(userList);

        log.info("List of users was sorted");

        Assertions.assertEquals(32, sortedByAge.get(0).getAge(),"Test is failed");
        Assertions.assertEquals(33, sortedByAge.get(1).getAge(),"Test is failed");
        Assertions.assertEquals(46, sortedByAge.get(2).getAge(),"Test is failed");
        Assertions.assertEquals(48, sortedByAge.get(3).getAge(),"Test is failed");

        log.info("Method sortedByAge was tested and test is passed");


    }

    @AfterEach
    public void afterTest(){
        log.info("Smoke Test was finished");
    }
}





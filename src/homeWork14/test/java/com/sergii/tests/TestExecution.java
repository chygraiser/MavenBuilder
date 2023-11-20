package com.sergii.tests;

import com.sergii.code.Main;
import com.sergii.code.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.sergii.code.Main.calculateAverageAge;

public class TestExecution {

    private static final Logger log = LogManager.getLogger(TestExecution.class);

    @BeforeAll
    public static void beforeTest() {
        log.info("Smoke Test was started");
    }

    @Nested
    class TestExecutionSubPointB {
        @BeforeEach
        public void beforeTestB() {
            log.info("TestExecutionSubPointB - Test was started");
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

        log.info("TestExecutionSubPointB - List of users was created");

        List<User> sortedByAge = Main.sortByAge(userList);

        log.info("TestExecutionSubPointB - List of users was sorted");

        Assertions.assertEquals(32, sortedByAge.get(0).getAge(),"Test is failed");
        Assertions.assertEquals(33, sortedByAge.get(1).getAge(),"Test is failed");
        Assertions.assertEquals(46, sortedByAge.get(2).getAge(),"Test is failed");
        Assertions.assertEquals(48, sortedByAge.get(3).getAge(),"Test is failed");

        log.info("TestExecutionSubPointB - Method sortedByAge was tested and test is passed");

    }
        @AfterEach
        public void afterTestB() {
            log.info("TestExecutionSubPointB - Test was finished");
        }


    }
    @Nested
    class TestExecutionSubPointC {

        @BeforeEach
        public void beforeTestC() {
            log.info("TestExecutionSubPointC - Test was started");
        }

        @Test
        public void testCalculateAverageAge() {
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

            double averageAge = Main.calculateAverageAge(userList);

            double expectedAverage = (32 + 88 + 64 + 33 + 57 + 48 + 62 + 46 + 50 + 72) / 10.0;

            Assertions.assertEquals(expectedAverage, averageAge,"Test is failed");

            log.info("TestExecutionSubPointC - Method testCalculateAverageAge was tested and test is passed");
        }

        @AfterEach
        public void afterTestC() {
            log.info("TestExecutionSubPointC - Test was finished");
        }

    }

    @AfterAll
    public static void afterTest(){
        log.info("Smoke Test was finished without Errors");
    }



}





package com.sergii.tests;

import com.sergii.code.Main;
import com.sergii.code.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.sergii.code.Main.calculateAverageAge;
import static org.junit.Assert.*;

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


    @RepeatedTest(10)
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
        public void checkCalculateAverageAge() {
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

            log.info("TestExecutionSubPointC - List of users was created");

            double averageAge = Main.calculateAverageAge(userList);

            log.info("TestExecutionSubPointC - Average Age of users was calculated");

            double expectedAverage = (32 + 88 + 64 + 33 + 57 + 48 + 62 + 46 + 50 + 72) / 10.0;

            log.info("TestExecutionSubPointC - Expected Average Age of users was calculated");

            Assertions.assertEquals(expectedAverage, averageAge,"Test is failed");

            log.info("TestExecutionSubPointC - Method testCalculateAverageAge was tested and test is passed");
        }

        @AfterEach
        public void afterTestC() {
            log.info("TestExecutionSubPointC - Test was finished");
        }

    }

    @Nested
    class TestExecutionSubPointD {

        @BeforeEach
        public void beforeTestD() {
            log.info("TestExecutionSubPointD - Test was started");
        }

        @Test

        public void checkSortByFirstNameAndAge() {
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

            log.info("TestExecutionSubPointD - List of users was created");

            Main.sortByFirstNameAndAge(userList);

            log.info("TestExecutionSubPointD - List of users was sorted");

            Assertions.assertEquals("Alfredo", userList.get(0).getFirstName(), "Test is failed");
            Assertions.assertEquals("Cristiano", userList.get(1).getFirstName(), "Test is failed");
            Assertions.assertEquals("Diego", userList.get(2).getFirstName(), "Test is failed");
            Assertions.assertEquals("Gerd", userList.get(3).getFirstName(), "Test is failed");

            log.info("TestExecutionSubPointD - Method sortByFirstNameAndAge was tested and test is passed");

        }

        @AfterEach
        public void afterTestD() {
            log.info("TestExecutionSubPointD - Test was finished");
        }



    }

    /*@Nested
    class TestExecutionSubPointE {

        @BeforeEach
        public void beforeTestE() {
            log.info("TestExecutionSubPointE - Test was started");
        }

        @Test
        public void testHasUsersWithSALastName() {
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

            log.info("TestExecutionSubPointE - List of users was created");

            // Test when there are users with last names starting with 'S' or 'A'
            Assertions.assertEquals(false, hasUsersWithSALastName(userList), "Users with SA are not presented");
           *//* Assertions.assertEquals(false, Main.hasUsersWithSALastName(userList), "Users with SA are presented");*//*

            // Modify the list so that there are no users with last names starting with 'S' or 'A'
            *//*userList.get(0).setSecondName("Allegri");  // Changing Messi to Doe
            userList.get(1).setSecondName("Shevchecko");  // Changing Pele to Doe*//*

            // Test when there are no users with last names starting with 'S' or 'A'
            *//*Assertions.assertFalse(Main.hasUsersWithSALastName(userList));*//*
        }

        @AfterEach
        public void afterTestE() {
            log.info("TestExecutionSubPointE - Test was finished");
        }

    }*/

    @Nested
    class TestExecutionSubPointF {

        @BeforeEach
        public void beforeTestF() {
            log.info("TestExecutionSubPointF - Test was started");
        }

        @Test
        void checkAreAllUsersOver18() {
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

            log.info("TestExecutionSubPointF - List of users was created");

            List<User> userListUnder18 = new ArrayList<>();
            userListUnder18.add(new User("Young", "Player", 16));
            userListUnder18.add(new User("Teen", "Player", 17));

            log.info("TestExecutionSubPointF - List of users under 18 was created");

            Assertions.assertFalse(Main.areAllUsersOver18(userListUnder18), "Not all users in the list are over 18");

            log.info("TestExecutionSubPointF - Method checkAreAllUsersOver18 was tested and test is passed");
        }

        @AfterEach
        public void afterTestF() {
            log.info("TestExecutionSubPointF - Test was finished");
        }


    }






    @AfterAll
    public static void afterTest(){
        log.info("Smoke Test was finished without Errors");
    }



}





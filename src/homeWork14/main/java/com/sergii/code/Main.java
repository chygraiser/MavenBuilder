package com.sergii.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class Main {

    public static void main(String[] args) {

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

        List<User> sortedByAge = sortByAge(userList);

        for (User user : sortedByAge) {
            System.out.println(user.getFirstName() + " " + user.getSecondName() + " - " + user.getAge());
        }

    }

    public static List<User> sortByAge(List<User> userList) {
        List<User> sortedList = new ArrayList<>(userList);
        Collections.sort(sortedList, comparingInt(User::getAge));
        return sortedList;
    }

    public static double calculateAverageAge(List<User> userList) {
        if (userList.isEmpty()) {
            return 0;
        }

        int totalAge = 0;

        for (User user : userList) {
            totalAge += user.getAge();
        }

        return (double) totalAge / userList.size();
    }

    public static void sortByFirstNameAndAge(List<User> userList) {
        Collections.sort(userList, Comparator
                .comparing(User::getFirstName)
                .thenComparing(User::getAge));
    }

}

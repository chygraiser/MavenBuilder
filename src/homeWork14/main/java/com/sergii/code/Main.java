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

        boolean allOver18 = areAllUsersOver18(userList);

        if (allOver18) {
            System.out.println("All users are over 18 years old.");
        } else {
            System.out.println("Not all users are over 18 years old.");
        }

        boolean hasUsersWithSA = hasUsersWithSandAinLastName(userList);

        if (hasUsersWithSA) {
            System.out.println("There are users with last names starting with 'S' or 'A'.");
        } else {
            System.out.println("No users with last names starting with 'S' or 'A'.");
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

    public static boolean areAllUsersOver18(List<User> userList) {
        return userList.stream().allMatch(user -> user.getAge() > 18);
    }

    public static boolean hasUsersWithSandAinLastName(List<User> userList) {
            for (User user : userList) {
                String lastName = user.getSecondName().toLowerCase();
                if (lastName.startsWith("s") || lastName.startsWith("a")) {
                    return true;
                }
            }
            return false;
        }
}

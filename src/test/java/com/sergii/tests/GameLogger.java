package com.sergii.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static java.lang.String.*;

public class GameLogger {
    private static final Logger log = LogManager.getLogger(GameLogger.class);
    public static void main(String[] args) {

        Scanner action = new Scanner(System.in);

        int wins = 0;
        int losses = 0;
        int draws = 0;

        while (true){
            System.out.println("Please enter your action : rock, paper or scissors. If you want to end game please enter 'stop' ");

            String myAction = action.nextLine();

            if (myAction.equals("stop")) {
                break;
            }

            if (!myAction.equals("rock") && !myAction.equals("paper") && !myAction.equals("scissors")) {
                log.error("Action is not valid. Please enter valid action: rock, paper or scissors");
                System.out.println("    ");
            } else {

                int random = (int) (Math.random() * 3);

                String computerAction = "";

                if (random == 0) {
                    computerAction = "rock";
                } else if (random == 1) {
                    computerAction = "paper";
                } else if (random == 2) {
                    computerAction = "scissors";
                } else {
                    log.fatal("Sorry something went wrong");
                }
                log.info(format("Computer action is: %s", computerAction));

                if (myAction.equals(computerAction)) {
                    log.info("You have draw");
                    draws++;
                } else if ((myAction.equals("rock") && computerAction.equals("scissors")) || (myAction.equals("scissors") && computerAction.equals("paper")) || (myAction.equals("paper") && computerAction.equals("rock"))) {
                    log.info("Congratulations, You Won.");
                    wins++;
                } else {
                    log.info("Sorry, You Lost.");
                    losses++;
                }
                System.out.println("    ");

            }

            log.debug(String.format("You have won %d games", wins));
            log.warn("You have lost " + losses + " games");
            log.trace(String.format("You have draw %d games", draws));
            System.out.println("    ");

        }

        if (wins > losses) {
            log.info("You are lucky, you won more games than you lost.");
        } else if (wins < losses) {
            log.info("Don't give up, you lost more games than you won.");
        } else {
            log.info("You have same numbers of lost and won games.");
        }
        System.out.println("    ");
        log.info("Thank You for the game. You are the best!");

    }
}





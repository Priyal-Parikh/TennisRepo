package com.bnpp.kata;

import java.util.Scanner;

public class PlayTennisGame
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TennisGame tennisGame = initilizeGame(scanner);
        startGame(scanner, tennisGame);
        scanner.close();
    }

    private static void startGame(Scanner scanner, TennisGame tennisGame)
    {
        boolean isGameOver = false;
        System.out.println("Let the game begin!!!");

        while (!isGameOver)
        {
            System.out.print("Enter the player who has scored the point. Either " + tennisGame.getPlayerOne() + " or "
                    + tennisGame.getPlayerTwo() + ": ");

            String ballScoringPlayerName = scanner.nextLine();
            if (ballScoringPlayerName != null && ballScoringPlayerName.equalsIgnoreCase(tennisGame.getPlayerOne())) {
                tennisGame.playerOneScores();
            }
            else if(ballScoringPlayerName != null && ballScoringPlayerName.equalsIgnoreCase(tennisGame.getPlayerTwo())) {
                tennisGame.playerTwoScores();
            }
            else System.out.println("!!!!!Invalid Player Name!!!!!");

            String score = tennisGame.getScore();
            displayCurrentScoreCard(score);
            isGameOver = score.contains("wins");
        }

        System.out.println("Game is now over!");
    }

    private static TennisGame initilizeGame(Scanner scanner)
    {
        String playerOneName;
        String playerTwoName;

        while (true)
        {
            System.out.print("Enter Player 1 Name: ");
            playerOneName = scanner.nextLine();
            System.out.print("Enter Player 2 Name: ");
            playerTwoName = scanner.nextLine();

            if (!playerOneName.equalsIgnoreCase(playerTwoName))
            {
                break;
            }

            System.out.println("Player names cant be same!!!");
        }
        return new TennisGame(playerOneName, playerTwoName);
    }

    private static void displayCurrentScoreCard(String score) {
        System.out.println("***************************************************");
        System.out.println("Current Score :"+score);
        System.out.println("***************************************************");
    }
}

package string.class_problems;

import java.util.Random;

public class RockPaperScissors {

    // Decides the winner of one round using the standard rules
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        // Predefined player moves for a live demo (N = 5 rounds)
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int rounds = playerMoves.length;
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = moves[random.nextInt(3)]; // random computer move
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.printf("%-8s %-14s %-16s %s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-14s %-16s %s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
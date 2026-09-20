import java.util.*;

public class RockPaperScissors {
    private static int wins = 0, losses = 0, draws = 0;
    private static int totalRounds;
    private static List<String[]> roundTable = new ArrayList<>();

    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();
        
        String result;
        if (playerMove.equals(computerMove)) {
            result = "Draw";
            draws++;
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                   (playerMove.equals("paper") && computerMove.equals("rock")) ||
                   (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            result = "Player Wins";
            wins++;
        } else {
            result = "Computer Wins";
            losses++;
        }
        
        roundTable.add(new String[]{String.valueOf(roundTable.size() + 1), playerMove, computerMove, result});
        return result;
    }

    public static String getRandomMove() {
        Random rand = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[rand.nextInt(moves.length)];
    }

    public static void printSummary() {
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
        if (totalRounds > 0) {
            double winPercent = ((double) wins / totalRounds) * 100;
            System.out.printf("Win %% = %.1f%%\n", winPercent);
        }
    }

    public static void printScoreboard() {
        System.out.println("\nRound Table:");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("------|-------------|---------------|--------");
        for (String[] row : roundTable) {
            System.out.printf("  %s   |    %s      |     %s       |  %s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rounds: ");
        totalRounds = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.println("\n--- Rock Paper Scissors Sim ---");
        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("Round " + i + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();
            String computerMove = getRandomMove();
            String result = playRound(playerMove, computerMove);
            System.out.println("Round " + i + " Result: " + result);
        }
        
        printScoreboard();
        printSummary();
        sc.close();
    }
}
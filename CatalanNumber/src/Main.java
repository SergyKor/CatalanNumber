import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pairs of parentheses (N): ");
        int n = scanner.nextInt();
        if (n < 0) {
                System.out.println("N must be a non-negative number.");
                return; // Exit the program if the input is invalid
            }
        // Create an array to store the results of subproblems
        long[] dp = new long[n + 1];

        // Base case: There is one valid expression for 0 pairs of parentheses (empty string)
        dp[0] = 1;
        // Calculate the number of valid expressions for all values from 1 to N
        for (int i = 1; i <= n; i++) {
            dp[i] = 0; // Initialize dp[i] to 0
            for (int j = 0; j < i; j++) {
                // Apply the recurrence relation:
                // dp[i] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] + ... + dp[i - 1] * dp[0]
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println("The number of valid parentheses expressions is: " + dp[n]);
    }
}
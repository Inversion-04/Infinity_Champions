import java.util.*;

public class count_primes {

    // Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static boolean isPrime(int n) {
        int cnt = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                cnt++;
            }
            if (cnt > 2) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimesBrute(int n) {
        if (n == 0 || n == 1)
            return 0;

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    // Optimized (Sieve of Eratosthenes)
    // Time Complexity: O(n log log n)
    // Space Complexity: O(n)
    public static int countPrimesOptimized(int n) {
        if (n <= 1)
            return 0;

        boolean[] hash = new boolean[n];
        Arrays.fill(hash, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (hash[i]) {
                for (int j = i * i; j < n; j += i) {
                    hash[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (hash[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println("Brute Count: " + countPrimesBrute(n));
        System.out.println("Optimized Count: " + countPrimesOptimized(n));
    }
}

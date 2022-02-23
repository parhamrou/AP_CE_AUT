public class Solution {
    // prints all prime factors of n in order
    public static void printFactors(int n) {
        // find prime numbers from 2 to n
        int primes[] = new int[200]; // ** array has to have s specific size
        int primeCount = 0;
        for (int it = 2; it <= n; it += 1) {
            boolean isPrime = true;
            // check if `it` is prime
            for (int jt = 2; jt * jt <= it; jt += 1) {
                if (it % jt == 0) {
                    isPrime = false; // ** "flase", not "False"
                }
            }
            if (isPrime == true) {
                primes[primeCount++] = it;
            }
        }
        // find prime factors of n
        for (int it = 0; it < primeCount; it += 1) {
            if (n == 1) {
                break;
            }
            while (n % primes[it] == 0) { // ** condition of while has to be in paranthesis
                System.out.print(primes[it] + " "); // ** "System" not "system"
                n /= primes[it];
            }
        }
        System.out.print("\n"); // ** "System.out" not "Systemout"
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

	public static void main(String[] args) {

		// Set up Scanner and read in the INTEGER value to be factored
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = reader.nextInt();
		reader.close();

		// Declare variables needed for iteration
		int remaining = number;
		int currentPrime = 2;
		ArrayList<Integer> result = new ArrayList<Integer>();

		// Begin checking what primes the number is divisible by and add
		// them to the results as we find them
		do {

			while (remaining % currentPrime == 0) {
				result.add(currentPrime);
				remaining /= currentPrime;
			}

			currentPrime = nextPrime(currentPrime);

		} while (remaining > 1); // once the remainder is zero, were done!

		// Print out the results
		System.out.println(String.format("%d's prime factors are: %s", number, result.toString()));
		// For debugging... or fun!
		System.out.println("\n" + Primes.toString());

	}

	private static int nextPrime(int currentPrime) {
		// Here, we will return the next largest prime from the ArrayList Primes
		// if the last prime in equal to the largest prime in the list, then we
		// calculate what the next largest prime should be, and add it to the
		// list

		int lastPrime = Primes.get(Primes.size() - 1);
		if (currentPrime == lastPrime) {
			int nextPrime = currentPrime + 1;
			while (!IsPrime(nextPrime))
				nextPrime++;
			Primes.add(nextPrime);
		}

		for (int i = 0; i < Primes.size(); i++) {
			if (Primes.get(i) > currentPrime)
				return Primes.get(i);
		}
		return 0;
	}

	private static boolean IsPrime(int nextPrime) {
		// This is a simple method to determine if a number is prime, returning
		// true if it is and false otherwise

		for (int i = 2; i < nextPrime / 2; i++)
			if (nextPrime % i == 0)
				return false;
		return true;
	}

	// This list is used to initially "brute force" the factorization up above,
	// it can be as long as you want, but the first 20 or so should be plenty
	private static List<Integer> Primes = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 23));
}

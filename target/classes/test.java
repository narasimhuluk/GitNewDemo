
public class test {

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		// Create Scanner object to take input from the user
		Scanner scanner = new Scanner(System.in);

		// Take input number from the user
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		// Check if the number is prime
		if (isPrime(number)) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}

		// Close scanner
		scanner.close();
	}

	// Method to check if a number is prime
	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false; // Numbers less than or equal to 1 are not prime
		}

		// Check for divisibility from 2 to the square root of the number
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false; // If divisible, it's not prime
			}
		}

		return true; // If no divisors were found, it's prime
	}
}

}

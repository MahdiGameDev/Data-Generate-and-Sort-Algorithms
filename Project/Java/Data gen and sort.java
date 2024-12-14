
import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) { // Main function
		Scanner scanner = new Scanner(System.in); // For user inputs
		
		System.out.println("Enter the size of the array :");
		int size = scanner.nextInt();
		System.out.println("Enter the maximum number :");
		int max = scanner.nextInt();
		
		int[] array = new int[size];
		
		// Generate an array
		generate_array(array, size, max);
		
		// Output the generated array
		output_array(array, size);
		
		// Sort the array
		sort_array(array, size);
		
		// Output the sorted array
		output_array(array, size);
	}
	
	static void generate_array(int[] array, int size, int max) {
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			boolean add = false;
			while (!add) {
				int attemps = 0;
				// Generate a random number
				int rand_number = random.nextInt(max) + 1;
				
				// Check the number
				for (int j = 0; j < size; j++) {
					if (array[j] != rand_number) attemps++;
				}
				
				// Add the number
				if (attemps >= size) {
					array[i] = rand_number;
					add = true;
				}
			}
		}
	}

	static void output_array(int[] array, int size) {
		System.out.print("\n[");
		for (int i = 0; i < size; i++) {
			if (i == 0) System.out.print(array[i]);
			else {
				System.out.print(" ,");
				System.out.print(array[i]);
			}
		}
		System.out.print("]\n");
	}

	static void sort_array(int[] array, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (array[j] < array[j - 1]) {
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}
	}
}
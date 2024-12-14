#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

void generate_array(int* array, int size, int max) {
    for (int i = 0; i < size; i++) {
        bool add = false;
        while (!add) {
            // Generate a random number
            int attemps = 0;
            int rand_number = (rand() % max) + 1;

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

void output_array(int* array, int size) {
    printf("\n[");
    for (int i = 0; i < size; i++) {
        if (i == 0) printf("%d", array[i]);
        else {
            printf(" ,");
            printf("%d", array[i]);
        }
    }
    printf("]\n");
}

void sort_array(int* array ,int size) {
    for (int i = 0; i < size ; i++) {
        for (int j = 1; j < size - i; j++) {
            if (array[j] < array[j - 1]) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
    }
}

int main() {
    srand(time(0));
    int array[2024];
    int size;
    int max;
    printf("Enter the size of the array :\n");
    scanf("%d", &size);
    printf("Enter the maximum number :\n");
    scanf("%d", &max);

    // Generate an array
    generate_array(array, size, max);

    // Output the generated array
    output_array(array, size);

    // Sort the array
    sort_array(array, size);

    // Output the sorted array
    output_array(array, size);
    
    return 0;
}
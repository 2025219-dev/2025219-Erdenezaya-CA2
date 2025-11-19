/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2025219.erdenezaya.ca2;

import java.util.Scanner;

/**
 *
 * @author Erdenezaya
 */
public class ErdenezayaCA2 {
    
    // BubbleSort for String array
    public static void bubbleSort(String[] A) {
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (A[j].compareToIgnoreCase(A[j + 1]) > 0) {
                    String temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // Menu loop
        while (true) {
            System.out.println("\n--- Do You wish to SORT or SEARCH ---");
            System.out.println("1. SORT");
            System.out.println("2. SEARCH");
            System.out.println("3. ADD RECORDS");
            System.out.println("4. Create a binary tree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            

            switch (choice) {
                case 1:
                    // --- SORTING NAMES ---
                    System.out.print("How many names do you want to sort? ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); 

                    String[] names = new String[count];

                    System.out.println("Enter the names:");
                    for (int i = 0; i < count; i++) {
                        System.out.print("Name " + (i + 1) + ": ");
                        names[i] = scanner.nextLine();
                    }

                    // Sort the names
                    bubbleSort(names);

                    // Print the sorted list
                    System.out.println("\nSorted Names:");
                    for (String name : names) {
                        System.out.println(name);
                    }
                    break;
                case 2:
                    
                    System.out.println("under construction");
                    break;
                case 3:
                    System.out.println("under construction");
                    break;
                case 4:
                    System.out.println("under construction");
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting program.");
                    
                    return;
                default:
                    // Handles invalid menu choices
                    System.out.println("Invalid choice, try again.");
            }
        }
    

        
    }
    
}

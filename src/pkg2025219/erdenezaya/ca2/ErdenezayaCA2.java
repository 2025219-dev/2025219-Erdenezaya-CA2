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
                    System.out.println("under construction");
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

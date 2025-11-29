/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2025219.erdenezaya.ca2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Erdenezaya
 */
public class ErdenezayaCA2 {
    
    // Linear Search for String array (case-insensitive)
    public static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(key)) {
                return i; // return index if found
            }
        }
        return -1; // not found
    }
    
    
    static int height(Node root) {
    if (root == null) return 0;

    int leftH = height(root.left);
    int rightH = height(root.right);

    return 1 + Math.max(leftH, rightH);
}
    
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

    // Load full records (for search)
public static String[] loadFullRecordsFromFile(String filename) {
    ArrayList<String> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        boolean skipHeader = true;
        while ((line = br.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }
            records.add(line); // full line: Name,Manager,Department
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
    return records.toArray(new String[0]);
}

// ======================= BINARY SEARCH TREE + BFS =======================

// Node that stores a String (Name)
    static class Node {
        String data;
        Node left, right;

        Node(String value) {
            data = value;
            left = right = null;
        }
    }

    // Insert into BST (alphabetical order)
    static Node insert(Node root, String value) {
        if (root == null) {
            return new Node(value);
        }
        if (value.compareToIgnoreCase(root.data) < 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Count nodes for BFS Queue size
        static int countNodes(Node root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    // Queue for BFS
    static class ArrayQueue {
        Node[] arr;
        int front, rear, capacity;

        ArrayQueue(int capacity) {
            this.capacity = capacity;
            arr = new Node[capacity];
            front = rear = -1;
        }

        boolean isEmpty() { return front == -1; }

        boolean isFull() { return (rear + 1) % capacity == front; }

        void enqueue(Node node) {
            if (isFull()) return;
            if (isEmpty()) front = rear = 0;
            else rear = (rear + 1) % capacity;
            arr[rear] = node;
        }

        Node dequeue() {
            if (isEmpty()) return null;
            Node temp = arr[front];
            if (front == rear) front = rear = -1;
            else front = (front + 1) % capacity;
            return temp;
        }
    }

    // BFS Traversal
    static void bfs(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        int totalNodes = countNodes(root);
        ArrayQueue queue = new ArrayQueue(totalNodes);
        queue.enqueue(root);

        System.out.println("\nBFS Traversal (Names in Level Order):");

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            System.out.println(current.data + " ");

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
        System.out.println("\n");
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
                     // --- SORT NAMES FROM FILE ---
                    System.out.print("Enter the filename (with extension, e.g., records.txt): ");
                    String filename = scanner.nextLine();

                    String[] names = loadFullRecordsFromFile(filename);

                    if (names.length == 0) {
                        System.out.println("No names found in file.");
                        break;
                    }

                    // Sort names
                    bubbleSort(names);

                    // Print sorted list
                    System.out.println("\nSorted Names from File:");
                    for (String n : names) {
                        System.out.println(n);
                    }
                    break;
                case 2:
                    
                    // --- SEARCH NAME IN FILE ---
                    System.out.print("Enter the filename (with extension, e.g., records.txt): ");
                    String filenameSearch = scanner.nextLine();

                    String[] fullRecords = loadFullRecordsFromFile(filenameSearch);

                    if (fullRecords.length == 0) {
                        System.out.println("No names found in file or file could not be read.");
                        break;
                    }

                    System.out.print("Enter the name to search: ");
                    String key = scanner.nextLine();
                    
                    // Extract names for linear search
                    String[] namesArray = new String[fullRecords.length];
                    for (int i = 0; i < fullRecords.length; i++) {
                        namesArray[i] = fullRecords[i].split(",")[0]; // Name column
                    }

                    int index = linearSearch(namesArray, key);

                    if (index != -1) {
                        // Name found — print full record
                        String[] parts = fullRecords[index].split(",");
                        System.out.println("\nRecord Found:");
                        System.out.println("Name: " + parts[0]);
                        System.out.println("Manager: " + parts[1]);
                        System.out.println("Department: " + parts[2]);
                    } else {
                        System.out.println("Name not found in file.");
                    }
                    break;
                case 3:
                        System.out.print("Enter the filename to add record to (with extension, e.g., records.txt): ");
                        String filenameAdd = scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter Manager: ");
                        String newManager = scanner.nextLine();

                        System.out.print("Enter Department: ");
                        String newDepartment = scanner.nextLine();

                        try (FileWriter fw = new FileWriter(filenameAdd, true); 
                             PrintWriter pw = new PrintWriter(fw)) {
                            // Append new record in CSV format
                            pw.println(newName + "," + newManager + "," + newDepartment);
                            System.out.println("Record added successfully!");
                        } catch (IOException e) {
                            System.out.println("Error writing to file: " + e.getMessage());
                        }
                    break;
                case 4:
                    System.out.println("\n--- Create Binary Tree from File (Names Only) ---");
                    System.out.print("Enter filename (with extension): ");

                    String treeFile = scanner.nextLine();
                    String[] recordsForTree = loadFullRecordsFromFile(treeFile);

                    if (recordsForTree.length == 0) {
                        System.out.println("File is empty or unreadable.");
                        break;
                    }

                    // Build BST from Names (first column)
                    Node rootTree = null;
                    for (String rec : recordsForTree) {
                        String name = rec.split(",")[0].trim();
                        rootTree = insert(rootTree, name);
                    }

                    System.out.println("\nBinary Tree created successfully!");
                    bfs(rootTree);

                    int total = countNodes(rootTree);
                    int h = height(rootTree);

                    System.out.println("Total nodes in tree: " + total);
                    System.out.println("Height of tree: " + h);

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

package StudentsNotesManager.main;

import StudentsNotesManager.methods.AddNotes;
import StudentsNotesManager.methods.DeleteNotes;
import StudentsNotesManager.methods.SearchNotes;
import StudentsNotesManager.methods.ViewNotes;

import java.util.Scanner;

public class NotesManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------- WELCOME TO MY STUDENTS NOTE MANAGER SYSTEM ----------\n");

        System.out.print("Enter the file name to store your notes (with .txt): ");
        String fileName = scanner.nextLine();

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n---------- STUDENTS NOTES MANAGER ----------");
            System.out.println("1. Add Notes");
            System.out.println("2. View Notes");
            System.out.println("3. Search Notes");
            System.out.println("4. Delete Notes");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AddNotes.addNotes(fileName, scanner);
                    break;
                case 2:
                    ViewNotes.viewNotes(fileName);
                    break;
                case 3:
                    SearchNotes.searchNotes(fileName, scanner);
                    break;
                case 4:
                    DeleteNotes.deleteNotes(fileName, scanner);
                    break;
                case 5:
                    System.out.println("\nExiting.... Thanks for using my Students Notes Manager!");
                    break;
                default:
                    System.out.println("\nInvalid Choice! Please Try Again!");
            }
        }
        scanner.close();
    }
}

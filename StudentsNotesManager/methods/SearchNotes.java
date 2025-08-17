package StudentsNotesManager.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class SearchNotes {
    public static void searchNotes(String fileName, Scanner scanner) {
        File file = new File("data/" + fileName);

        if (!file.exists()) {
            System.out.println("\nFile not found!");
            return;
        }

        System.out.print("\nEnter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            boolean found = false;

            System.out.println("\nSearching for \"" + keyword + "\" in " + fileName + "...\n");
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    found = true;
                }
                lineNumber++;
            }

            if (!found) {
                System.out.println("No matching notes found.");
            }
        } catch (Exception e) {
            System.out.println("\nException: An Error Occurred! " + e.getMessage());
        }
    }
}

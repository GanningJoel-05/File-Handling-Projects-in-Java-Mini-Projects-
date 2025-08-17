package StudentsNotesManager.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ViewNotes {
    public static void viewNotes(String fileName) {
        File file = new File("data/" + fileName);

        if (!file.exists()) {
            System.out.println("\nNo notes found! File does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isEmpty = true;

            System.out.println("\n---------- YOUR NOTES ----------");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("\nNo notes available yet.");
            }
        }
        catch (Exception e) {
            System.out.println("\nException: An Error Occurred! " + e.getMessage());
        }
    }
}

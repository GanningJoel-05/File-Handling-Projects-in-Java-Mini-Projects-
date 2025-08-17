package StudentsNotesManager.methods;

import java.io.File;
import java.util.Scanner;

public class DeleteNotes {
    public static void deleteNotes(String fileName, Scanner scanner) {
        File file = new File("data/" + fileName);

        if (!file.exists()) {
            System.out.println("\nFile does not exist!");
            return;
        }

        System.out.print("\nAre you sure you want to delete the file (yes/no)? ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            if (file.delete()) {
                System.out.println("\nFile deleted successfully!");
            } else {
                System.out.println("\nFailed to delete the file.");
            }
        } else {
            System.out.println("\nDeletion cancelled.");
        }
    }
}

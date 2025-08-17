package StudentsNotesManager.methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddNotes {
    public static void addNotes(String fileName, Scanner scanner) {
        System.out.println("\n---------- ADD YOUR NOTES ----------");
        System.out.print("Enter your Note: ");
        String note = scanner.nextLine();

        try {
            File file = new File("data");
            if (!file.exists()) {
                file.mkdir();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/" + fileName, true))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String timeStamp = dtf.format(LocalDateTime.now());
                writer.write("[" + timeStamp + "] " + note);
                writer.newLine();
                writer.flush();
                System.out.println("\nNote Added Successfully!");
            }
        }
        catch (Exception e) {
            System.out.println("\nException: An Error Occurred! " + e.getMessage());
        }
    }
}

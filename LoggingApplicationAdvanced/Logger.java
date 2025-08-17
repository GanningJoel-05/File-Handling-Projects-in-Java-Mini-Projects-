package LoggingApplicationAdvanced;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String path;
    private final DateTimeFormatter formatter;

    Logger(String path) throws Exception{
        File file = new File(path);

        if(!file.exists()) {
            file.createNewFile();
        }
        this.path = path;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void log(String message, LogLevel level) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [%s] %s", timestamp, level, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(formattedMessage);
            writer.newLine();
        }
        catch(IOException e) {
            System.out.println("Failed to Log Message: " +formattedMessage);
        }
    }
}

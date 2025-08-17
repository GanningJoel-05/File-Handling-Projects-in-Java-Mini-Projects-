package LoggingApplicationAdvanced;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Logger logger = new Logger("LogMaster.txt");

            logger.log("Application Started", LogLevel.INFO);
            logger.log("User 'Ganning Joel' logged in", LogLevel.INFO);
            logger.log("Fetching Data from Database", LogLevel.DEBUG);
            logger.log("Error: Database Connection Failed!", LogLevel.ERROR);
            logger.log("Retrying Connection...", LogLevel.WARN);
            logger.log("Application Closed", LogLevel.INFO);

            System.out.println("Logs Written Successfully to LogMaster.txt");
        }
        catch(IOException e) {
            System.out.println("Exception Occurred! " +e.getMessage());
        }
    }
}

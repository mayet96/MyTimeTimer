package ru.id61890868.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeLogger {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");


    private final File logPath;
    private static final String HOME = System.getProperty("user.home");
    private static final String LOG_FOLDER_NAME = "myTimeTimer";
    private static final String FILE_NAME = "times.out";

    public TimeLogger(String logPath) {
        this.logPath = new File(logPath) {
        };
    }

    public TimeLogger(){
        logPath = new File(HOME + File.separator + FILE_NAME);
        if (!logPath.exists()){
            try {
                logPath.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void log(String msg){
        FileWriter log;
        try {
            log = new FileWriter(logPath, true);
            log.append(dateFormat.format(new Date())).append(": ").append(msg).append("\n");
            log.flush();
            System.out.println(logPath);
            log.close();
        } catch (IOException e) {
            throw new RuntimeException(e) ;
        }
    }
}

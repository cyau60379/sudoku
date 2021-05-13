package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
	private static Logger mLogger = new Logger();
	private String path;
	private File fichero;

	// private constructor
	private Logger() {
		path = Paths.get("src", "resources", "logs.txt").toString();
		fichero = new File(path);
	}

	// getter
	public static Logger getLogger() {
		return mLogger;
	}
	
	public void write(String pMessage) {
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			LocalDate date = LocalDate.now();  // Create a date object
		    LocalTime time = LocalTime.now();
			FileWriter file = new FileWriter(path, true);
			file.write("[" + date + " " + time + "] " + pMessage + "\n");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

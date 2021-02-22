package console;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileLoader {

    Logger logger = Logger.getLogger(FileLoader.class);

    CommandReader commandReader = new CommandReader();

    public BufferedReader loadFile() {
        BufferedReader myFile = null;
        boolean fileExist = true;

        while (fileExist) {
            String inputText = commandReader.getNextCommand();

            if (inputText.equals("exit")) {
                new Console().goodbye();
                System.exit(0);
                break;
            } else {
                try {
                    inputText = "DAT_MT_EURUSD_M1_202011.csv";
                    myFile = new BufferedReader(new FileReader(inputText));
                    fileExist = false;
                    logger.info("File found.");
                } catch (FileNotFoundException e) {
                    logger.info(inputText + " - Try again. This file not exist.");
                }
            }
        }
        return myFile;
    }
}

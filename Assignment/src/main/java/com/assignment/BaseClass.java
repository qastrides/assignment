package com.assignment;

import java.io.*;
import java.util.Properties;
public class BaseClass {
    public static Properties prop = new Properties();
    static BufferedReader reader;
    public static String baseURL;
    public static FileInputStream fis;
    public static String configPropertyFile;

    // #################################################################################################################################
    // Function Name:  readPropFile
    // Input Parameter: None
    // Output Parameter: None
    // Description:  A base class method to fetch URI from properties file (config.properties) in src/test/java/resources/properties/ and
    // to be used by it's inherited classes
    // #################################################################################################################################
    public static void readPropFile() {
        try {
            // Mac
            Utilities.setConfigPropertyFile(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
            // Windows
            //Utilities.setConfigPropertyFile(System.getProperty("user.dir") + "\\src\\test\\properties\\config.properties");
            try {
                fis = new FileInputStream(Utilities.getConfigPropertyFile());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(fis);
                baseURL = prop.getProperty("Base_URL");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
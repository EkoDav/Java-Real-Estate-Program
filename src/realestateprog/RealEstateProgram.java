 /*
 * This real estate program will read and store Property and Realtor 
 * data for use by a Colorado real estate office. It can also generate reports 
 * based on this data.
 */
package realestateprog;

import java.io.*;
import java.util.Scanner;

/**
 * @author Erik Davis 
 * @version 6.0
 */
public class RealEstateProgram {
    static RealtorLogImpl realtorLogImpl = new RealtorLogImpl();
    static PropertyLogImpl propertyLogImpl = new PropertyLogImpl();
    static PrintImpl printImpl = new PrintImpl();
    
    /**
     * Main method will run the program in order: call the method to read the 
     * input file and process, display all stored data, and generate a sales 
     * report.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String INPUT_FILENAME = "input/assn6input1.txt";
        final String REQUEST_FILENAME = "input/realtorRequests1.txt";
        final String OUTPUT_FILENAME = "output/assn6salesReport.txt";
        
        //Read and Process datafile for Realtors and Properties
        readDataFile(INPUT_FILENAME);
        
        //Display all data stored
        System.out.println("Realtor List: ");
        realtorLogImpl.traverseDisplay(realtorLogImpl.getRoot());
        System.out.println();
        System.out.println("Property List: ");
        propertyLogImpl.traverseDisplay();
        
        //Read and Process datafile for Property sold/unsold inquiries by Realtor
        printImpl.generateSalesReport(REQUEST_FILENAME, OUTPUT_FILENAME,
                realtorLogImpl, propertyLogImpl);
    }
    
    /**
     * Method to verify all realtor attributes and add the realtor object to 
     * the log.
     * 
     * @param realtorValues - Attributes read from one line of the data file. 
     */
    public static void addRealtor(String [] realtorValues){
        Realtor oneRealtor = new Realtor();
        oneRealtor = setRealtorAttributes(oneRealtor, realtorValues);
        realtorLogImpl.add(oneRealtor);
    }
    
    /**
     * Method to set Property values and add the property object to the log. 
     * 
     * @param propertyValues - Property values read from the data file. 
     */
    public static void addProperty(String [] propertyValues){
        Property oneProperty = new Property();
        oneProperty = setPropertyAttributes(oneProperty, propertyValues);
        propertyLogImpl.add(oneProperty);
    }
    
    /**
     * Method to open, read, and parse a data file and then call on other methods
     * depending on the kind of data read.
     * 
     * @param INPUT_FILENAME - File name and location of input file. 
     */
    public static void readDataFile(String INPUT_FILENAME) {
        File dataFile = new File(INPUT_FILENAME);
        Scanner fileScanner = null;
        String oneLine;
        String [] lineValues;
        int lineCount = 0;
        
        System.out.println("Reading data file...");
        System.out.println();
        
        try {
            fileScanner = new Scanner(dataFile);
        }
            catch (FileNotFoundException e) {
                System.err.println("FILE NOT FOUND: " + INPUT_FILENAME);
                System.exit(1);
            }
        
        while (fileScanner.hasNextLine()) {
            oneLine = fileScanner.nextLine();
            lineValues = oneLine.split(",");
            lineCount++;
            
            if (lineValues[0].equalsIgnoreCase("REALTOR")) {
                if (lineValues[1].equalsIgnoreCase("ADD")) {
                    addRealtor(lineValues);
                } else {
                    System.out.println("  ERROR: A line in the file is not "
                            + "formatted correctly to ADD an object.");
                }
            } else if (lineValues[0].equalsIgnoreCase("PROPERTY")) {
                if (lineValues[1].equalsIgnoreCase("ADD")) {
                    addProperty(lineValues);
                } else {
                    System.out.println("  ERROR: A line in the file is not "
                            + "formatted correctly to ADD an object.");
                }
            } else {
                System.out.println("  ERROR: A line in the file is not "
                        + "designated as REALTOR or PROPERTY.");
            }
        }
        
        //Close data file
        fileScanner.close();
        
        System.out.println();
        System.out.println("Data Read Finished: Read " + lineCount 
                + " lines of data.");
        System.out.println();
    }
    
    /**
     * The setRealtorAttributes method will use the parameters to call upon 
     * the Realtor class methods to set all data values for one object. Values 
     * that need conversion are converted.
     * 
     * @param oneRealtor - The empty object.
     * @param realtorAtt - The attributes read from data file stored in an array.
     * @return oneRealtor - The object with data values set.
     */
    public static Realtor setRealtorAttributes(Realtor oneRealtor, 
            String [] realtorAtt) {
        double commAsDouble = Double.parseDouble(realtorAtt[6]);
        
        oneRealtor.setLicenseNum(realtorAtt[2]);
        oneRealtor.setFirstName(realtorAtt[3]);
        oneRealtor.setLastName(realtorAtt[4]);
        oneRealtor.setPhoneNum(realtorAtt[5]);
        oneRealtor.setCommPercent(commAsDouble);
        
        return oneRealtor;
    }
    
    /**
     * The setPropertyAttributes method will use the parameters to call upon 
     * the Property class methods to set all data values for one object. Values 
     * that need converted are converted.
     * 
     * @param oneProperty - The empty object
     * @param propertyAtt - The attributes read from data file stored in an array.
     * @return oneProperty - The object with data values set.
     */
    public static Property setPropertyAttributes(Property oneProperty,
            String [] propertyAtt) {
        int mlsAsInt = Integer.parseInt(propertyAtt[2]);
        int zipAsInt = Integer.parseInt(propertyAtt[7]);
        int bedAsInt = Integer.parseInt(propertyAtt[8]);
        double bathAsDouble = Double.parseDouble(propertyAtt[9]);
        boolean soldAsBoolean = "Y".equalsIgnoreCase(propertyAtt[10]);
        double priceAsDouble = Double.parseDouble(propertyAtt[11]);
        
        oneProperty.setMlsNum(mlsAsInt);
        oneProperty.setLicenseNum(propertyAtt[3]);
        oneProperty.setAddress(propertyAtt[4]);
        oneProperty.setCity(propertyAtt[5]);
        oneProperty.setState(propertyAtt[6]);
        oneProperty.setZipCode(zipAsInt);
        oneProperty.setNumBed(bedAsInt);
        oneProperty.setNumBath(bathAsDouble);
        oneProperty.setSold(soldAsBoolean);
        oneProperty.setAskingPrice(priceAsDouble);
        
        return oneProperty;
    }
}
/*
 * The PrintImpl Class contains the method needed to write Realtor and Property 
 * data to an output file in the established format. 
 */
package realestateprog;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Erik Davis
 * @version 6.0
 */
public class PrintImpl {
    /**
     * Method to get data from the Realtor and Property logs and write it to an
     * output file in specified format based on requests information read in an
     * input file. 
     * 
     * 
     * @param inputFilename - The requests from realtors about property information.
     * @param outputFilename - The output file name and path for the report.
     * @param realtorTree - The Realtor tree holding the data for Realtors.
     * @param propertyTree - The Property tree holding the data for Properties.
     */
    public void generateSalesReport(String inputFilename, String outputFilename,
            RealtorLogImpl realtorTree, PropertyLogImpl propertyTree) {
        String oneLine;
        String [] lineValues;
        Realtor currRealtor;
        Property currProperty;
        Boolean sold;
        
        try {
            File inFile = new File(inputFilename);
            Scanner fileScanner = new Scanner(inFile);
            File outFile = new File(outputFilename);
            PrintWriter fout = new PrintWriter(outFile);
            
            while (fileScanner.hasNextLine()) {
                oneLine = fileScanner.nextLine();
                lineValues = oneLine.split(" ");
                
                currRealtor = realtorTree.getRealtor(realtorTree.getRoot(), 
                        lineValues[0]);
                if (currRealtor != null) {
                    fout.println("Realtor " + currRealtor.getLicenseNum() + ", "
                            + currRealtor.getFirstName() + " " + currRealtor.
                            getLastName());
                    for (int idx = 1; idx < lineValues.length; idx++) {
                        int mlsAsInt = Integer.parseInt(lineValues[idx]);
                        currProperty = propertyTree.getProperty(mlsAsInt);
                        if (currProperty != null) {
                            sold = currProperty.isSold();
                            if (sold) {
                                fout.println("\tProperty " + mlsAsInt + " is SOLD");
                            } else {
                                fout.println("\tProperty " + mlsAsInt + " is "
                                    + "available for $" + currProperty.
                                      getAskingPrice());
                            }
                        } else {
                            fout.println("\tProperty " + mlsAsInt + " does not exist");
                        }
                    }
                } else {
                    fout.println("Realtor " + lineValues[0] + " does not exist");
                }
            }
            fout.close();
            System.out.println();
            System.out.println("Report is complete -- located in file: " 
                    + outputFilename);
            System.out.println();
        } catch (IOException ioex) {
            System.out.println("Either the file " + outputFilename + " or the file " 
                    + inputFilename + " could not be opened.");
        }
    }
}
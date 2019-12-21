package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistentStorage {

    // Variables
    public static final String ProductFileName = "products.txt";
    public static final String SupplierFileName = "suppliers.txt";
    public static final String OrderFileName = "orders.txt";
    
    // Constructor
    public PersistentStorage() {
    }

    // Command Functions
    public void saveData(int guide, String data) {
        String targetFileName = getFileName(guide);
        if (targetFileName != "") {
            try {
                // Assume default encoding.
                FileWriter fileWriter
                        = new FileWriter(targetFileName);
                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter
                        = new BufferedWriter(fileWriter);

                // Write data
                bufferedWriter.write(data);
                // Always close files.
                bufferedWriter.close();

            } catch (IOException ex) {
                System.out.println("Error writing to file '"
                        + targetFileName + "'");
            }
        }
    }
    
    // Query Functions    
    public String getFileName(int guide) {
       switch (guide) {
            case 1:
                return ProductFileName;
            case 2:
                return SupplierFileName;
            case 3:
                return OrderFileName;
            default:
                return "";
        } 
    }
    
    public int getItemCount(int guide) {
        
        String targetFileName = getFileName(guide);
        int count = 0;
        String line = null;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(targetFileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                count++;
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + targetFileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + targetFileName + "'");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Error reading file '"
                    + targetFileName + "'");
        }
        return count;
    }
    
    public String getLineItem(int guide, int lineItem) {
        
        String targetFileName = getFileName(guide);
        String line = null;
        int counter = 0;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(targetFileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (counter == lineItem){
                    return line;
                }
                counter++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + targetFileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + targetFileName + "'");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Error reading file '"
                    + targetFileName + "'");
        }
        return line;
    }
}

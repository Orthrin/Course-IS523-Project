package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseAction {

    // Variables
    public static final String ProductFileName = "products.txt";
    public static final String SupplierFileName = "suppliers.txt";
    public static final String OrderFileName = "orders.txt";
    
    // Instantiation
    public Store store;
    
    // Constructor
    public DatabaseAction() {
        store = Store.getInstance();
    }

    // Command Functions
    // +load data
    public void loadData(int guide) {
       String line = null;
        String targetFileName = null;

        switch (guide) {
            case 1:
                targetFileName = ProductFileName;
                break;
            case 2:
                targetFileName = SupplierFileName;
                break;
            case 3:
                targetFileName = OrderFileName;
                break;
            default:
                targetFileName = "";
        }
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(targetFileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] p = new String[5];
                String[] data = line.split(",");
                for(int iii=0; iii<data.length;iii++) {
                    p[iii] = data[iii];
                }
                
                System.out.println(guide + " " + p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4]);
                store.loadItems(guide, p[0], p[1], p[2], p[3], p[4]);
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
    }

    public void saveData(int guide, String data) {
        String targetFileName;
        switch (guide) {
            case 1:
                targetFileName = ProductFileName;
                break;
            case 2:
                targetFileName = SupplierFileName;
                break;
            case 3:
                targetFileName = OrderFileName;
                break;
            default:
                targetFileName = "";
        }
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

}

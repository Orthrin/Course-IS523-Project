import java.io.*;
import domain.Store;
import java.util.HashMap;
import view.UIFacade;

public class Main {

    // Variables
    public static final String fileName = "products.txt";

    // Instantiation
    public static Store store = new Store();

    public static void main(String[] args) {

        // Procedure
        loadData();
        UIFacade.getInstance().start(store);

    }

    // Command Methods
    public static void loadData() {
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] p = line.split(",");
                store.loadItems(p[0], p[1], p[2], p[3], p[4]);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

//    public static void saveData() {
//        try {
//            // Assume default encoding.
//            FileWriter fileWriter
//                    = new FileWriter(fileName);
//
//            // Always wrap FileWriter in BufferedWriter.
//            BufferedWriter bufferedWriter
//                    = new BufferedWriter(fileWriter);
//
//            // Note that write() does not automatically
//            // append a newline character.bufferedWriter.write("Hello there,");
//            bufferedWriter.write(store.getWriteData()); // BURAYA YAZILACAK
//            // Always close files.
//            bufferedWriter.close();
//        } catch (IOException ex) {
//            System.out.println(
//                    "Error writing to file '"
//                    + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }
//    }
}

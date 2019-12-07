import java.io.*;

public class Main {

    public static final String fileName = "objects.txt";
    public static Root root;

    public static void main(String[] args) throws Exception {
        loadData();
// initialize and run your application here....
// do not forget to call saveData() before exiting!!!
    }

    public static void loadData() {
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                int itemCounter = 1; 
                String[] parameter = line.split(",");
                System.out.println("Id: " + parameter[0]);
                System.out.println("Desc: " + parameter[1]);
                System.out.println("Min: " + parameter[2]);
                System.out.println("Max: " + parameter[3]);
                System.out.println("Curr: " + parameter[4]);
                ++itemCounter;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public static void saveData() {
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}

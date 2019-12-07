import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Get File Path
        URL path = Main.class.getResource("products.txt");

        //Initialize objects
        File productsFile = new File(path.getFile());
        Scanner fileReader = new Scanner(productsFile);
        fileReader.useDelimiter(",");

        //Read File
        Integer counter = 0;
        while (fileReader.hasNext()) {
            System.out.println(fileReader.next());
        }
    }
}
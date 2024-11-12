import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// Helper class implementing the Comparator interface to compare files by size
class SortBySize implements Comparator<File> {
    
    // Used for sorting in descending order of file size
    public int compare(File x, File y){
      return ((int)y.length()) - ((int)x.length());
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Prompt the user to enter the folder path
        System.out.println("Please, enter the folder path :");

        // se BufferedReader to read user input with ISO-8859-1 encoding
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in, "ISO-8859-1")
        );

        // Read the folder path from user input
        String path = reader.readLine();

        // Create a File object for the specified directory
        File directory = new File(path);

        // Create an array containing all files in the directory
        File[] files = directory.listFiles();

        // Check if the folder path is valid or empty
        if (files != null)
        {
            // Show only the 3 largest files or fewer if there are not 3 files
            Arrays.sort(files, new SortBySize());

            // Show only the 3 largest files or less if there are not 3 files 
            int numberOfFilesShow = files.length;
            if(numberOfFilesShow > 3)
                numberOfFilesShow = 3;

            for (int i = 0; i < numberOfFilesShow; i++){
                System.out.print(files[i].getName() + " |   ");
                System.out.println(files[i].length() + " Byte");
            }
        }else{

            // Can't find files
            System.out.println("Invalid path or no files found in this directory");
            System.out.println("Directory tested is : " + path);
        }
        

    }
}

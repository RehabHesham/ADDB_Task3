import java.util.Scanner;
import java.io.*;
import java.nio.file.*;


public class FileIO {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        try{
            File myObj = new File("myfile.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("myfile.txt");
            System.out.println("Enter what you want to write in the file: ");
            myWriter.write(sc.nextLine());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Path file = Paths.get("myfile.txt");
        while (true) {
            System.out.println("Enter the letter you want to look for: ");
            char lookFor = sc.next().charAt(0);
            int count = new CountLetter(lookFor, file).count();
            System.out.format("File '%s' has %d instances of letter '%c'.%n",
                    file, count, lookFor);
        }
    }

    public static class CountLetter {
        private char lookFor;
        private Path file;

        CountLetter(char lookFor, Path file) {
            this.lookFor = lookFor;
            this.file = file;
        }

        public int count() throws IOException {
            int count = 0;
            try (InputStream in = Files.newInputStream(file);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
            {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        if (lookFor == line.charAt(i)) {
                            count++;
                        }
                    }
                }
            } catch (IOException x) {
                System.err.println(x);
            }
            return count;
        }

    }
}
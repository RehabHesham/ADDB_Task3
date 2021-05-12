import java.util.*;
import java.io.*;

/*
run from cmd
javac Collections.java
java Collections myfile1.txt 9
                 ___________ _
                      ^      ^
                      |      |
                 file name   repetation number
*/
public class Collections {

        public static void main(String[] args) {
            final int assumedLineLength = 50;
            File file = new File(args[0]);
            List<String> fileList =
                    new ArrayList<String>((int)(file.length() / assumedLineLength) * 2);
            BufferedReader reader = null;
            int lineCount = 0;
            try {
                reader = new BufferedReader(new FileReader(file));
                for (String line = reader.readLine(); line != null;
                     line = reader.readLine()) {
                    fileList.add(line);
                    lineCount++;
                }
            } catch (IOException e) {
                System.err.format("Could not read %s: %s%n", file, e);
                System.exit(1);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {}
                }
            }
            int repeats = Integer.parseInt(args[1]);
            Random random = new Random();
            System.out.println("");
            for (int i = 0; i < repeats; i++) {
                System.out.format("%d: %s%n", i,
                        fileList.get(random.nextInt(lineCount - 1)));
                System.out.println("");
            }
        }
    }

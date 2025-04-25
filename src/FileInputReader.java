import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInputReader {
    private static void readData(String filename) {
        int fromVertex, toVertex, capacity;
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            int numberOfVertices = Integer.parseInt(fileReader.nextLine().trim());

            while (fileReader.hasNextLine()) {
                String[] connections = fileReader.nextLine().trim().split(" ");
                for (int i = 0; i < connections.length; i += 3) {
                    fromVertex = Integer.parseInt(connections[0]);
                    toVertex = Integer.parseInt(connections[1]);
                    capacity = Integer.parseInt(connections[2]);
                    System.out.print(fromVertex + " ");
                    System.out.print(toVertex + " ");
                    System.out.print(capacity + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Can not process. Try again.");
        }
    }
}

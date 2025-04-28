import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInputReader {
    public static void processFileData(String filename) {
        int fromVertex, toVertex, capacity, numberOfVertices;
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            //read the number of vertices
            numberOfVertices = Integer.parseInt(fileReader.nextLine().trim());

            //create the object to find the maximum flow value
            FordFulkerson fordFulkerson = new FordFulkerson(numberOfVertices);

            //read the start vertex, end vertex and the edge capacity
            while (fileReader.hasNextLine()) {
                String[] connections = fileReader.nextLine().trim().split(" ");
                for (int i = 0; i < connections.length; i += 3) {
                    fromVertex = Integer.parseInt(connections[0]);
                    toVertex = Integer.parseInt(connections[1]);
                    capacity = Integer.parseInt(connections[2]);
                    //create a new edge using the read data
                    fordFulkerson.createNewEdge(fromVertex,toVertex,capacity);
                }
            }
            //display the graph as adjacency list
            fordFulkerson.displayAdjacencyList();
            System.out.println();

            //display the calculated maximum flow value
            fordFulkerson.findMaximumFlowValue();
            System.out.println("Maximum flow value is " + fordFulkerson.getMaximumFlowValue());
        }
        catch (IOException e) {
            System.out.println("Can not find the file");
        }
    }
}

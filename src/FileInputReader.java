import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInputReader {
    public static NetworkGraph processFileData(String filename) {
        int fromVertex, toVertex, capacity, numberOfVertices;
        NetworkGraph networkGraph = null;
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            //read the number of vertices
            numberOfVertices = Integer.parseInt(fileReader.nextLine().trim());

            networkGraph = new NetworkGraph(numberOfVertices);

            //read the start vertex, end vertex and the edge capacity
            while (fileReader.hasNextLine()) {
                String[] connections = fileReader.nextLine().trim().split(" ");
                fromVertex = Integer.parseInt(connections[0]);
                toVertex = Integer.parseInt(connections[1]);
                capacity = Integer.parseInt(connections[2]);
                //create a new edge using the read data
                networkGraph.createNewEdge(fromVertex, toVertex, capacity);
            }
            //display the graph as adjacency list
            networkGraph.displayAdjacencyList();
            System.out.println();

            //closing the file reader
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("Can not find the file");
        }
        return networkGraph;
    }
}

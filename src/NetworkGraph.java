import java.util.ArrayList;
public class NetworkGraph {
    private final int numberOfVertex;
    private final ArrayList<ArrayList<Edge>> graphConnections;

    public NetworkGraph(int numberOfVertex){
        this.numberOfVertex = numberOfVertex;
        graphConnections = new ArrayList<>();

        for (int i = 0; i < numberOfVertex; i++) {
            graphConnections.add(new ArrayList<Edge>());
        }
    }

    public void createNewEdge(int fromVertex, int toVertex, int capacity){
        // create a new edge and add to the arraylist
        Edge forwordEdge = new Edge(fromVertex,toVertex,capacity);
        graphConnections.get(fromVertex).add(forwordEdge);
    }

    public void displayAdjacencyList(){
        for (int i = 0; i < numberOfVertex; i++) {
            System.out.print(i);
            for (Edge node : graphConnections.get(i)){
                System.out.print(node);
            }
            System.out.println();
        }
    }
}

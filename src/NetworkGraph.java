import java.util.ArrayList;
public class NetworkGraph {
    private final int numberOfVertex;
    private final int sourceVertex;
    private final int sinkVertex;
    private final ArrayList<ArrayList<Edge>> graphConnections;

    public NetworkGraph(int numberOfVertex){
        this.numberOfVertex = numberOfVertex;
        graphConnections = new ArrayList<>();

        this.sourceVertex = 0;
        this.sinkVertex = numberOfVertex - 1;

        for (int i = 0; i < numberOfVertex; i++) {
            graphConnections.add(new ArrayList<Edge>());
        }
    }

    //getters for the instance variables
    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public int getSinkVertex() {
        return sinkVertex;
    }

    public ArrayList<ArrayList<Edge>> getGraphConnections() {
        return graphConnections;
    }

    public void createNewEdge(int fromVertex, int toVertex, int capacity){
        //create the forward edge
        Edge forwordEdge = new Edge(fromVertex,toVertex,capacity);
        //create the reverse edge
        Edge reverseEdge = new Edge(toVertex,fromVertex,0);

        forwordEdge.setReverseEdge(reverseEdge);
        reverseEdge.setReverseEdge(forwordEdge);

        //add to the adjacency list
        graphConnections.get(fromVertex).add(forwordEdge);
        graphConnections.get(toVertex).add(reverseEdge);
    }

    public void displayAdjacencyList(){
        System.out.println("The network - ");
        System.out.println();
        for (int i = 0; i < numberOfVertex; i++) {
            System.out.print("Vertex number " + i + " :");
            for (Edge node : graphConnections.get(i)){
                if (!node.isReverseEdge()){
                    System.out.print(node);
                }
            }
            System.out.println();
        }
    }
}
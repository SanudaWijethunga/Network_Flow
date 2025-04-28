import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class FordFulkerson extends NetworkGraph{
    private boolean[] visitedVertices;
    private Edge[] edgePath;
    private int maximumFlowValue;

    public FordFulkerson(int numberOfVertices){
        super(numberOfVertices);
    }

    public int getMaximumFlowValue() {
        return maximumFlowValue;
    }

    private boolean findPath(int sourceVertex, int sinkVertex){
        //get the total number of vertices
        int numberOfVertices = getNumberOfVertex();
        //array to mark the visited vertices
        visitedVertices = new boolean[numberOfVertices];
        //array to mark the founded path
        edgePath = new Edge[numberOfVertices];

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(sourceVertex);
        visitedVertices[sourceVertex] = true;

        int currentVertex;
        while (!bfsQueue.isEmpty() && !visitedVertices[sinkVertex]){
            //remove the current element from the queue
            currentVertex = bfsQueue.poll();
            for (Edge edge : getGraphConnections().get(currentVertex)){
                int connectedVertex = edge.getToVertex();
                if (edge.getRemainingEdgeCapacity() > 0 && !visitedVertices[connectedVertex]){
                    edgePath[connectedVertex] = edge;
                    visitedVertices[connectedVertex] = true;
                    bfsQueue.add(connectedVertex);
                }
            }
        }
        return visitedVertices[sinkVertex];
    }

    public void findMaximumFlowValue() {
        maximumFlowValue = 0;
        int sourceVertex = getSourceVertex();
        int sinkVertex = getSinkVertex();

        System.out.println("Calculating the maximum flow value - ");
        System.out.println();
        System.out.println("Source vertex - " + sourceVertex);
        System.out.println("Sink vertex - " + sinkVertex);
        System.out.println();

        while (findPath(sourceVertex, sinkVertex)) {
            int bottleneckValue = edgePath[sinkVertex].getRemainingEdgeCapacity();

            //find the minimum flow of the path
            for (int currentValue = sinkVertex; currentValue != sourceVertex; currentValue = edgePath[currentValue].getFromVertex()) {
                bottleneckValue = Math.min(bottleneckValue, edgePath[currentValue].getRemainingEdgeCapacity());
            }

            for (int currentValue = sinkVertex; currentValue != sourceVertex; currentValue = edgePath[currentValue].getFromVertex()) {
                edgePath[currentValue].addEdgeFlowValue(bottleneckValue);
            }

            //calculate the maximum flow value
            maximumFlowValue += bottleneckValue;

            System.out.print("Path : ");
            printPath(sourceVertex,sinkVertex);
            System.out.println();
            System.out.println("Flow value of the path = " + bottleneckValue);
            System.out.println();
        }
    }

    private void printPath(int sourceVertex, int sinkVertex) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int currentVertex = sinkVertex; currentVertex != sourceVertex; currentVertex = edgePath[currentVertex].getFromVertex()) {
            path.addFirst(currentVertex);
        }

        path.addFirst(sourceVertex);

        //print the path
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" - ");
            }
        }
    }
}
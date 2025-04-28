import java.util.*;
public class FordFulkerson {
    private final NetworkGraph networkGraph;
    private boolean[] visitedVertices;
    private Edge[] edgePath;
    private int maximumFlowValue;

    public FordFulkerson(NetworkGraph networkGraph){
        this.networkGraph = networkGraph;
        findMaximumFlowValue();
    }

    //getter to return the maximum flow value
    public int getMaximumFlowValue() {
        return maximumFlowValue;
    }

    private boolean findPath(int sourceVertex, int sinkVertex){
        //array to mark the visited vertices
        visitedVertices = new boolean[networkGraph.getNumberOfVertex()];
        //array to mark the founded path
        edgePath = new Edge[networkGraph.getNumberOfVertex()];

        //queue to store the visited vertices
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(sourceVertex);
        visitedVertices[sourceVertex] = true;

        int currentVertex;
        while (!bfsQueue.isEmpty() && !visitedVertices[sinkVertex]){
            //remove the current element from the queue
            currentVertex = bfsQueue.poll();
            for (Edge edge : networkGraph.getGraphConnections().get(currentVertex)){
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
        //get the source and start vertex
        int sourceVertex = networkGraph.getSourceVertex();
        int sinkVertex = networkGraph.getSinkVertex();

        System.out.println("Calculating the maximum flow value - ");
        System.out.println("Source vertex - " + sourceVertex);
        System.out.println("Sink vertex - " + sinkVertex);
        System.out.println();
        System.out.println("Founded paths - ");
        System.out.println();

        while (findPath(sourceVertex, sinkVertex)) {
            StringBuilder displayFoundedPath = new StringBuilder();
            ArrayList<Integer> foundedPath = new ArrayList<>();

            int bottleneckValue = 0;
            boolean foundFirstEdge = true;

            for (int currentVertex = sinkVertex; currentVertex != sourceVertex; currentVertex = edgePath[currentVertex].getFromVertex()) {
                foundedPath.addFirst(currentVertex);
                int remainingEdgeCapacity = edgePath[currentVertex].getRemainingEdgeCapacity();

                if (foundFirstEdge) {
                    bottleneckValue = remainingEdgeCapacity;
                    foundFirstEdge = false;
                }
                else {
                    bottleneckValue = Math.min(bottleneckValue, remainingEdgeCapacity);
                }
            }
            foundedPath.addFirst(sourceVertex);

            displayFoundedPath.append("Path ").append(": ");
            for (int i = 0; i < foundedPath.size(); i++) {
                displayFoundedPath.append(foundedPath.get(i));
                if (i < foundedPath.size() - 1) {
                    displayFoundedPath.append(" - ");
                }
            }
            displayFoundedPath.append("\nFlow value of the path = ").append(bottleneckValue);
            displayFoundedPath.append("\n");

            //print the founded path with the flow value
            System.out.println(displayFoundedPath);

            for (int currentVertex = sinkVertex; currentVertex != sourceVertex; currentVertex = edgePath[currentVertex].getFromVertex()) {
                edgePath[currentVertex].addEdgeFlowValue(bottleneckValue);
            }
            //update the maximum flow value
            maximumFlowValue += bottleneckValue;
        }
    }
}
public class Edge {
    private final int fromVertex;
    private final int toVertex;
    private final int edgeCapacity;
    private int currentEdgeFlow;
    private Edge reverseEdge;

    public Edge(int fromVertex, int toVertex, int edgeCapacity){
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.edgeCapacity = edgeCapacity;
        this.currentEdgeFlow = 0;
    }

    //getters and setters for the instance variables
    public int getFromVertex() {
        return fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public void setReverseEdge(Edge reverseEdge) {
        this.reverseEdge = reverseEdge;
    }

    public boolean isReverseEdge(){
        return edgeCapacity == 0;
    }

    //update the flow value of the edge
    public void addEdgeFlowValue(int bottleNeckValue){
        currentEdgeFlow += bottleNeckValue;
        reverseEdge.currentEdgeFlow -= bottleNeckValue;
    }

    //calculate the remaining flow value of the edge
    public int getRemainingEdgeCapacity(){
        return this.edgeCapacity - this.currentEdgeFlow;
    }

    @Override
    public String toString(){
        return  " " + fromVertex + " - " + toVertex + " (" + edgeCapacity + ") ";
    }
}

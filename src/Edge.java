public class Edge {
    private int fromVertex;
    private int toVertex;
    private int edgeCapacity;
    private int currentEdgeFlow;

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

    public void setFromVertex(int fromVertex) {
        this.fromVertex = fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public void setToVertex(int toVertex) {
        this.toVertex = toVertex;
    }

    public int getEdgeCapacity() {
        return edgeCapacity;
    }

    public void setEdgeCapacity(int edgeCapacity) {
        this.edgeCapacity = edgeCapacity;
    }

    public int getCurrentEdgeFlow() {
        return currentEdgeFlow;
    }

    public void setCurrentEdgeFlow(int currentEdgeFlow) {
        this.currentEdgeFlow = currentEdgeFlow;
    }

    @Override
    public String toString(){
        return " - " + toVertex;
    }
}

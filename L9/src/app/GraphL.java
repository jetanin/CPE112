package app;
import java.util.*;

public class GraphL extends AdjL{
    boolean isDirected;
    int numVertices;
    int numEdges;

    public GraphL(boolean isDirected, int numVertices){
        super();
        this.isDirected = isDirected;
        this.numVertices = numVertices;
        this.numEdges = numEdges;
    }

    @Override
    public void addVertex(int vertex){
        this.adjacencyList.put(vertex, new ArrayList<>());
    }

    @Override
    public void addEdge(int src, int dest){
        this.adjacencyList.get(src).add(dest);
        if(this.isDirected == false){
            this.adjacencyList.get(dest).add(src);
        }
    }
}

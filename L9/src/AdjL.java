import java.util.*;

public abstract class AdjL {

    protected Map<Integer, List<Integer>> adjacencyList;

    public AdjL(){
        this.adjacencyList = new HashMap<>();
    }

    public abstract void addVertex(int vertex);
    public abstract void addEdge(int src, int dest);
}

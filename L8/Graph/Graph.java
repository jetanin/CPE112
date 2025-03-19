
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.*;

public abstract class Graph{
    protected int numVertices;
    protected Map<String, List<Edge>> adjacencyList;
    protected boolean isWeighted;

    public Graph(boolean isWeighted){
        this.numVertices = 0;
        this.isWeighted = isWeighted;
        this.adjacencyList = new HashMap<>();
    }

    protected void addNode(String name){
        if(!adjacencyList.containsKey(name)){
            adjacencyList.put(name, new ArrayList<>());
            numVertices++;
        }
    }

    //for unweighted graph
    public boolean addEdge(String src, String dest){
        if(!isWeighted){
            addEdgeWithWeight(src, dest, -1);
            return true;
        }
        else{
            return false;
        }
    }

    //for weighted graph
    public boolean addEdge(String src, String dest, int weight){
        if(isWeighted){
            addEdgeWithWeight(src, dest, weight);
            return true;
        }
        else{
            return false;
        }
    }

    public int getOutDegree(String name){
        if (!adjacencyList.containsKey(name)) {
            return 0;
        }
        return adjacencyList.get(name).size();
    }
    public int sumWeightOutDegree(String name){
        if (!adjacencyList.containsKey(name)) {
            return 0;
        }
        int sum = 0;
        for (Edge edge : adjacencyList.get(name)) {
            sum += edge.weight;
        }
        return sum;
    }

    public int getInDegree(String name){
        int inDegree = 0;
        for (String node : adjacencyList.keySet()) {
            for (Edge edge : adjacencyList.get(node)) {
                if (edge.dest.equals(name)) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }
    public int sumWeightInDegree(String name){
        int sum = 0;
        for (String node : adjacencyList.keySet()) {
            for (Edge edge : adjacencyList.get(node)) {
                if (edge.dest.equals(name)) {
                    sum += edge.weight;
                }
            }
        }
        return sum;
    }

    protected abstract void addEdgeWithWeight(String src, String dest, int weight);
}
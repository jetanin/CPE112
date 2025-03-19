public class UndirectedGraph extends Graph{
    public UndirectedGraph(boolean isWeighted){
        super(isWeighted);
    }

    @Override
    protected void addEdgeWithWeight(String src, String dest, int weight){
        addNode(src);
        addNode(dest);
        adjacencyList.get(src).add(new Edge(dest, weight));
        adjacencyList.get(dest).add(new Edge(src, weight));
    }
}
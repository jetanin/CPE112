public class DirectedGraph extends Graph{
    public DirectedGraph(boolean isWeighted){
        super(isWeighted);
    }

    @Override
    protected void addEdgeWithWeight(String src, String dest, int weight){
        addNode(src);
        addNode(dest);
        adjacencyList.get(src).add(new Edge(dest, weight));
    }
}
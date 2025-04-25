public class Main {
    public static void main(String[] args) throws Exception {
        GraphL graph = new GraphL(false, 8);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 7);

        MyAlgorithm myAlgorithm = new MyAlgorithm();
        System.out.println(myAlgorithm.bfs(graph, 0));

    }
}

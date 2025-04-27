package app;
public class Main {
    public static void main(String[] args) throws Exception {
        GraphL undirectedGraphL = new GraphL(false, 5);
        for(int i = 0; i < 5; i++){
            undirectedGraphL.addVertex(5);
        }
        undirectedGraphL.addEdge(0, 1);
        undirectedGraphL.addEdge(0, 3);
        undirectedGraphL.addEdge(3, 2);
        undirectedGraphL.addEdge(2, 4);
        undirectedGraphL.addEdge(4, 3);

        GraphL directedGraphL = new GraphL(true, 5);
        for(int i = 0; i < 5; i++){
            directedGraphL.addVertex(5);
        }
        directedGraphL.addEdge(0, 1);
        directedGraphL.addEdge(0, 3);
        directedGraphL.addEdge(3, 2);
        directedGraphL.addEdge(2, 4);
        directedGraphL.addEdge(4, 3);


        GraphM undirectedGraphM = new GraphM(false, 5);
        undirectedGraphM.addEdge(0, 1, 10);
        undirectedGraphM.addEdge(0, 3, 3);
        undirectedGraphM.addEdge(3, 2, 2);
        undirectedGraphM.addEdge(2, 4, 7);
        undirectedGraphM.addEdge(4, 3, 2);

        GraphM directedGraphM = new GraphM(true, 5);
        directedGraphM.addEdge(0, 1, 10);
        directedGraphM.addEdge(0, 3, 3);
        directedGraphM.addEdge(3, 2, 2);
        directedGraphM.addEdge(2, 4, 7);
        directedGraphM.addEdge(4, 3, 2);


        MyAlgorithm myAlgorithm = new MyAlgorithm();
        //GraphL
        System.out.println("Undirected Graph");
        System.out.println("BFS start node 0");
        System.out.println(myAlgorithm.bfs(undirectedGraphL, 0));
        System.out.println("Directed Graph");
        System.out.println("BFS start node 0");
        System.out.println(myAlgorithm.bfs(directedGraphL, 0));

        //GraphM
        System.out.println("Undirected Graph");
        System.out.println("DFS start node 0");
        System.out.println(myAlgorithm.dfs(undirectedGraphM, 0));
        System.out.println("Directed Graph");
        System.out.println("DFS start node 0");
        System.out.println(myAlgorithm.dfs(directedGraphM, 0));
        System.out.println();
    }
}

import java.util.*;

public class MyAlgorithm extends Algorithm{
    public MyAlgorithm() {

    }
    
    @Override
    public String dfs(GraphM graph, int startNode){
        boolean []isVisited = new boolean[graph.numVertices];
        StringBuffer str = new StringBuffer(100);
        return dfsUtil(graph, startNode, isVisited, str);
    }

    public String dfsUtil(GraphM graph, int startNode, boolean[] isVisited, StringBuffer str){
        isVisited[startNode] = true;
        str.append(startNode).append(" ");
        for(int i = 0; i < graph.numVertices; i++){
            if(graph.matrix[startNode][i] != 0 && !isVisited[i]){
                dfsUtil(graph, i, isVisited, str);
            }
        }
        return str.toString();
    }

    public String bfs(GraphL graph, int startNode){
        boolean[] isVisited = new boolean[graph.numVertices];
        StringBuffer str = new StringBuffer(100);
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        isVisited[startNode] = true;
        while(!q.isEmpty()){
            int current = q.peek();
            q.remove();
            str.append(current).append(" ");

            for(int i : graph.adjacencyList.get(current)){
                if(!isVisited[i]){
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
        return str.toString();
    }
}

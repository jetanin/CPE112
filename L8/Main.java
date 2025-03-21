
import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //INIT GRAPH
        System.out.println("Enter graph type (1 : Directed , 2 : Undirected)");
        int graphType = sc.nextInt();
        System.out.println("Is the graph weighted (true / false)");
        boolean isWeighted = sc.nextBoolean();

        Graph graph;
        if(graphType == 1){
            graph = new DirectedGraph(isWeighted);
        }else{
            graph = new UndirectedGraph(isWeighted);
        }
        

        //INPUT
        System.out.print("Enter number of edges : ");
        int numInput = sc.nextInt();
        int weight;
        String src, dest;
        for(int i = 0; i < numInput; i++){
            src = sc.next();
            dest = sc.next();
            if(isWeighted){
                weight = sc.nextInt();
                graph.addEdge(src, dest, weight);
            }else{
                graph.addEdge(src, dest);
            }
        }
        
        
        // System.out.println("\nEdges in the graph:");
        // for (String node : graph.adjacencyList.keySet()) {
        //     for (Edge edge : graph.adjacencyList.get(node)) {
        //         if (isWeighted) {
        //             System.out.println(node + " -> " + edge.dest + " (Weight: " + edge.weight + ")");
        //         } else {
        //             System.out.println(node + " -> " + edge.dest);
        //         }
        //     }
        // }


        //OUTPUT
        System.out.print("Enter number of output : ");
        int numOutput = sc.nextInt();
        String key;
        if(graphType == 1){
            for(int i = 0; i < numOutput; i++){
                System.out.print("Key : ");
                key = sc.next();
                if(isWeighted) {
                    System.out.print("Number of Degrees : ");
                    System.out.println(graph.getOutDegree(key));
                    System.out.print("Weight of Degrees : ");
                    System.out.println(graph.sumWeightOutDegree(key));
                }
                else{
                    System.out.print("Number of Degrees : ");
                    System.out.println(graph.getOutDegree(key));
                } 
            }
        }else{
            for(int i = 0; i < numOutput; i++){
                System.out.print("Key : ");
                key = sc.next();
                if(isWeighted) {
                    System.out.print("Number of Degrees : ");
                    System.out.println(graph.getOutDegree(key));
                    System.out.print("Weight of Degrees : ");
                    System.out.println(graph.sumWeightOutDegree(key));
                }
                else{
                    System.out.print("Number of Degrees : ");
                    System.out.println(graph.getOutDegree(key));
                } 
            }

        }

        sc.close();
    }
}
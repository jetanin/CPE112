//DRY => Don't Repeat Yourself

abstract class adjacencyMatrix{ //parent class, super class
    protected  int[][] matrix; // Protected => super class and sub class (inheritance => extend )
    protected  int numV;

    public adjacencyMatrix(int numV){
        this.numV = numV;
        matrix = new int[numV][numV];
    }

    public abstract void addEdge(int i, int j); //No implimentation
    public abstract void removeEdge(int i, int j); //No implimentation

    // public void addEdge(int i, int j){ //add e(i, j) 
    //     matrix[i][j] = 1;
    //     matrix[j][i] = 1;
    // }
    // public void removeEdge(int i, int j){
    //     matrix[i][j] = 0;
    //     matrix[j][i] = 0;
    // }

    public boolean hasEdge(int i, int j){
        return matrix[i][j] != 0;
    }

    public String toString(){
        StringBuffer buf = new StringBuffer("");
        for(int i = 0; i < numV; i++){
            for(int j = 0; j < numV; j++){
                buf.append(matrix[i][j]+" ");
            }
            buf.append("\n");
        }
        return buf + " ";
    }
}

class UndirectedGraph extends adjacencyMatrix{
    public UndirectedGraph(int numV){
        super(numV); //pass numV to superClass => adjacencyMatrix
    }

    @Override
    public void addEdge(int i, int j){ //add e(i, j)
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    @Override
    public void removeEdge(int i, int j){
        matrix[i][j] = 0;
        matrix[j][i] = 0;
    }
}

class DirectedGraph extends adjacencyMatrix{
    public DirectedGraph(int numV){
        super(numV);
    }

    @Override
    public void addEdge(int i, int j){ //add e(i, j)
        matrix[i][j] = 1;
    }

    @Override
    public void removeEdge(int i, int j){
        matrix[i][j] = 0;
    }
}

class WeightedGraph extends DirectedGraph{
    public WeightedGraph(int numV){
        super(numV);
    }

    public void addEdge(int i, int j, int val) { // Overloading
        matrix[i][j] = val;
    }
}


public class Graph{
    public static void main(String[] args) {
        // adjacencyMatrix g = new UndirectedGraph(4);
        adjacencyMatrix g = new DirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        System.out.println(g+"------\n"+g.toString());
        System.out.println("An edge between vertices 0 and 1: " + g.hasEdge(0, 1));
        g.removeEdge(1, 2);
        System.out.println(g);
        
        g = new UndirectedGraph(5);
        g.addEdge(3, 4);
        System.out.println(g);
        
        WeightedGraph g2 = new WeightedGraph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 3, 5);
        System.out.println(g2);
    }
}
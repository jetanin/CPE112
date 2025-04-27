package app;
public class GraphM extends AdjM {
    int numVertices;
    boolean isDirected;

    public GraphM(boolean isDirected, int n){
        super(n);
        this.numVertices = n;
        this.isDirected = isDirected;
    }

    @Override
    public void addEdge(int i, int j, int weight){
        this.matrix[i][j] = weight;
        if(!isDirected){
            this.matrix[j][i] = weight;
        }
    }

    @Override
    public int getWeight(int i, int j){
        return this.matrix[i][j];
    }
}

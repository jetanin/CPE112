import java.util.Scanner;

class IntArray{
    private int []data;
    private int size;

    public IntArray(int capacity){
        data = new int[capacity];
        size = capacity;
    }

    public int getSize(){
        return size;
    }

    public boolean setValue(int index, int value){
        if(index >= size){
            return false;
        }
        else{
            data[index] = value;
            return false;
        }
    }
   
    public int getValue(int index){
        return data[index];
    }
    
    public void insertElement(int index, int value){
        resize(); //size++, data[size++]
        for(int i = size; i >= index; i--){
            data[i] = data[i - 1];
            //[][] [][]
        }
        //[][](value)[][][]
        data[index] = value;
    }

    public void resize(){
        int newData[] = new int[size + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        size++;
        data = newData;
    }
}

public class Array {
    public static void main(String[] args){
        IntArray arr1 = new IntArray(capacity:10);

        arr1.size = 20;
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter size:");
        // IntArray wai = new IntArray(sc.nextInt());
        
        // for(int i = 0; i <  wai.getSize(); i++){
        //     wai.setValue(i, sc.nextInt());
        // }
        // System.out.println("Enter index and value:");
        // wai.insertElement(sc.nextInt(), sc.nextInt());

        // for(int i = 0; i < wai.getSize(); i++){
        //     System.out.printf("%d", wai.getValue(1));
        // }
        // sc.close();

    }
}

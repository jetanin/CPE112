import java.util.Scanner;
class TwoDArr{
     public static void main(String[] args){
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        int[][] mat1 = new int[3][3];
        int[][] mat2 = new int[3][3];
        int[][] mat3 = new int[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                mat1[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                mat2[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                mat3[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        for(int[] row : mat3){
            for(int element : row){

                System.out.print(element + " ");
            }
            System.out.println("");
        }
     }
    }
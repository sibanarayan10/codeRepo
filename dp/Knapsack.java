package allmethod.dp;

public class Knapsack {
    public static void main(String[]args){

        int rows = 3; // Number of rows
        int cols = 2; // Number of columns for each row

        int[][] numberArray = new int[rows][cols];

        // Initialize the 2D array with consecutive numbers
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                numberArray[i][j] = num++;
            }
        }

        // Print the 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(numberArray[i][j] + " ");
            }
            System.out.println();
        }
int arr[]={56,89};
        int Arrr[]=arr;

        System.out.println( knapsack(numberArray,9,2));
        String name ="bapun";
//        for(char i:name){
//
//        }
    }
    static int knapsack(int arr[][],int capacity,int n){
        int a=0,b=0;
        if(n<0||capacity==0){
            return 0;
        }
        if(arr[n][1]>capacity){
           a= knapsack(arr,capacity,n-1);
        }
        else{
            a=knapsack(arr,capacity,n-1);
            b=arr[n][0]+knapsack(arr,capacity-arr[n][1],n-1);

        }
        return a>b?a:b;
    }
}

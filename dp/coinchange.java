package allmethod.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class coinchange {
    static int coinChange(int[] arr, int target, int count, int n, List<Integer> list) {
        int a = 0, b = 0;
        if (target == 0) {
            count++;
            return count;
        } else if (target < 0 || n < 0) {
            return 0;
        }
        if (arr[n] > target) {
            a = coinChange(arr, target, count, n - 1, list);

        } else {
            a = coinChange(arr, target, count, n - 1, list);
            b = coinChange(arr, target - arr[n], count, n, list);

        }
        return a + b;
    }

    static int solveitbydp(int[] arr, int target) {
        int[][] dpArr = new int[arr.length + 1][target + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) {
                    dpArr[i][j] = 1;
                }
                if (i == 0) {
                    dpArr[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] > j) {
                    dpArr[i][j] = dpArr[i - 1][j];

                } else {
                    dpArr[i][j] = Math.max(dpArr[i][j - arr[i - 1]], dpArr[i - 1][j]);
                }

            }
        }

        return dpArr[arr.length][target];
    }



    static void generateParenthesis(char left, char right, int L, int R, List<String> list, String output) {
        if (L == 0 && R == 0) {
            list.add(output);
            return;
        }
if(L>0){
    String output1=output;
    output1+=left;
    generateParenthesis(left,right,L-1,R,list,output1);
}
if(R>L){
    String output2=output;
    output2+=right;
    generateParenthesis(left,right,L,R-1,list,output2);

}

    }

    static String LCS(String input, String input1, int n, int m) {
        if (n < 0 || m < 0) {
            return "";
        }
        String a = "";
        String b = "";
        if (input.charAt(n) == input1.charAt(m)) {
            return LCS(input, input1, n - 1, m - 1)+ input.charAt(n);
        }else{


        a = LCS(input, input1, n, m - 1);
        b = LCS(input, input1, n - 1, m);}
        return a.length() > b.length() ? a : b;
    }

//    static int sDPlongeststring(String input, String input1, int n, int m) {
//
//    }






    static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> superlist = new ArrayList<>();
        permutation(new ArrayList<>(array), new ArrayList<>(), superlist);
        return superlist;
    }

    static void permutation(List<Integer> array, List<Integer> outputArr, List<List<Integer>> superlist) {
        if (array.size() == 0) {
            superlist.add(new ArrayList<>(outputArr));
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            List<Integer> newArray = new ArrayList<>(array);
            List<Integer> newOutputArr = new ArrayList<>(outputArr);

            newOutputArr.add(newArray.get(i));
            newArray.remove(i);

            permutation(newArray, newOutputArr, superlist);
        }
    }
    static int getNthFib(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        int a = getNthFib(n - 1);
        int b = getNthFib(n - 2);
        return a + b;
    }
    static List<String> powerset(String input,String output,List<String>list){
        if(input.isEmpty()){
list.add(output);
            return new ArrayList<>();
        }
        String output1=output;
        String output2=output+input.charAt(0);
        powerset(input.substring(1),output2,list);
       powerset(input.substring(1),output1,list);


return list;
    }


    public static void main(String[] args) {
        System.out.println(getNthFib(6));
        List<String>list=new ArrayList<>();

        System.out.println(powerset("abc","",list));
        int highest=Integer.MIN_VALUE;
        int thrdhighest=0,secondhighest=0,first=0;
        int check=0;
        int num[]={141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        for(int i=0;i<num.length;i++){
            if(num[i]>highest&&check==0){
                thrdhighest=num[i];
                check++;
                continue;
            }
            if(num[i]>thrdhighest && check==1){
                secondhighest=num[i];
                check++;
                continue;
            }  if(num[i]>secondhighest && check==2){
                first=num[i];
                check++;
                continue;
            }  if(num[i]>first&&check==3){
                thrdhighest=secondhighest;
                secondhighest=first;

                first=num[i];
            }

        }
//        System.out.println(secondhighest);
        int a=-90;
        System.out.println(a%-12);
    }}

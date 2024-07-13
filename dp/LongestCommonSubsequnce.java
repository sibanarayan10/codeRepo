package allmethod.dp;

import java.util.*;

public class LongestCommonSubsequnce {
    static String  solvesequence(String input1,String input2,int n,int m){
        String  [][]dp=new String [n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j]="";
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(input1.charAt(i-1)==input2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+input1.charAt(i-1);
                }
                else{
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }



            }}
return dp[n][m];
    }
    static int traverseGraph(int traversalPath[][],int height,int width,int n ,int m){
       int counter=0;
        if(n==height-1&&m==width-1){

            return 1;
        }
        if (m + 1 < width) {
            counter += traverseGraph(traversalPath, height, width, n, m + 1);
        }

        // Move down
        if (n + 1 < height) {
            counter += traverseGraph(traversalPath, height, width, n + 1,m);}
return counter;
    }
    static void NumbersInPi(String PI,String []nums,String output,int counter,HashSet<String>set,List<Integer>list){
        if(output.equals(PI)){
            list.add(counter);
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            int length=nums[i].length();
            if(nums[i].equals(PI.substring(output.length(),output.length()+length))){
                set.add(nums[i]);

                NumbersInPi(PI,nums, output+nums[i],counter+1,new HashSet<>(set),list);

            }
        }

    }
    static void set(String input,String output,List<String>list){
        if(input.isEmpty()){
            list.add(output);

            return;
        }
        for(int i=0;i<input.length();i++){

            set(input.substring(0,i)+input.substring(i+1), output+input.charAt(i),list);
        }

    }
   static String countAndSay(int n) {
        String output ="";
        int i=0,j=0,count=0;
        List<String>list=new ArrayList<>();
        list.add(0,"1");
        for( i=2;i<=n;i++){
            for(j=list.get(0).length()-1;j>0;j--){
                if(list.get(0).charAt(j-1)!=list.get(0).charAt(j)){
                    output=Integer.toString(count+1)+list.get(0).charAt(j)+output;
                    count=0;
                    continue;
                }
                count++;
            }
            output=Integer.toString(count+1)+list.get(0).charAt(j)+output;
            list.add(0,output);
            output="";
            count=0;

        }
        return list.get(0);
    }



        public static void main(String[] args) {



            System.out.println(countAndSay(5));
        }
    }



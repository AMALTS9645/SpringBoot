package temp;

import java.io.*;
import java.util.*;
import java.lang.Math;
public class Solution {
    public static int oddXor(int N,int[] AR,int Q,int[] LEFT,int[] RIGHT){
        int leftLen = LEFT.length;
        int rightLen = RIGHT.length;

        for(int s=0;s<leftLen;s++){
            for(int i=LEFT[0],j=RIGHT[0];i<1;i++,j++){
                System.out.print(RIGHT[0]);
                System.out.print(AR[j]);
            }

        }

        return 0;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        N=scan.nextInt();
        int[] AR = new int[N];
        for(int j=0;j<N;j++){
            AR[j]=scan.nextInt();
        }
        int Q;
        Q=scan.nextInt();
        int[] LEFT = new int[Q];
        for(int j=0;j<Q;j++){
            LEFT[j]=scan.nextInt();
        }
        int[] RIGHT = new int[Q];
        for(int j=0;j<Q;j++){
            RIGHT[j]=scan.nextInt();
        }
        int result;
        result = oddXor(N,AR,Q,LEFT,RIGHT);
        System.out.print(result);
        return ;
    }
}
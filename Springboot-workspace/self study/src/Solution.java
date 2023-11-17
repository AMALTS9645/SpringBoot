import java.io.*;
import java.util.*;
import java.lang.Math;
public class Solution {
    public static int openHouse(int M,Integer t){
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : t){
            if(map.get(t) != 0){
                map.put(t,map.get(t)+1);
            }else{
                map.put(t,1);
            }
        }

        System.out.println(map);
        return 0;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        N=scan.nextInt();
        int M;
        M=scan.nextInt();
        Integer[] T = new Integer[N];
        for(int j=0;j<N;j++){
            T[j]=scan.nextInt();
        }
        int result;
        result = openHouse(M,T);
        System.out.print(result);
        return ;
    }
}
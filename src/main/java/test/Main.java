package test;

import java.util.Scanner;

/**
 * Created by Guoqing on 2016/9/12.
 */
public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] arr = new int[n][n][m];
        for (int i = 0; i < n; i++){
            arr[i][(i+1) % n][0] = 1;
            arr[i][(i-1+n) % n][0] = 1;
        }

        for (int k = 1; k < m; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j][k] = arr[i][(j-1+n)%n][k-1] + arr[i][(j+1) % n][k-1];
                }
            }
        }
        System.out.println(arr[n-1][n-1][m-1]);
    }
}

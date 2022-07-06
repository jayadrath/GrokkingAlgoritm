package com.algo.interview.questions;

import java.util.Deque;
import java.util.LinkedList;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
//        depthFirstSearch(arr);
        bfs(arr);
    }

    public static void depthFirstSearch(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] visited = new int[row][col];
        dfs(arr, 0, 0, visited);
    }

    public static void dfs(int[][] arr, int i, int j, int[][] visited) {
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || visited[i][j] == 1) return;
        visited[i][j] = 1;
        System.out.println(arr[i][j]);
        dfs(arr, i-1, j, visited);
        dfs(arr, i, j+1, visited);
        dfs(arr, i+1, j, visited);
        dfs(arr, i, j-1, visited);
    }

    public static void bfs(int[][] arr){
        int[][] visited = new int[arr.length][arr[0].length];
        int[][] directions = new int[][]{
            {-1,0},
            {0,1},
            {1,0},
            {0,-1},
            
        };
        Deque<int[]> queue = new LinkedList<>();
        int i =0, j = 0;
        queue.add(new int[] {i,j});
        visited[i][j] = 1;
        while(queue.size()>0){
            int[] curr = (int[]) queue.remove();
            i = curr[0];
            j = curr[1];
            System.out.println(arr[i][j]);
            for(int[] dir : directions){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newI<0 || newI>=arr.length || newJ<0 || newJ>=arr[0].length || visited[newI][newJ] == 1) continue;
                queue.add(new int[] {newI, newJ});
                visited[newI][newJ] = 1;
                 
            }
    }
}

}

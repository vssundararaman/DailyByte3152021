package com.vidya;

/**
 * 200. Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * Time Complexity O(M X N)
 * Space Complexity O(M X N)
 */
public class NumberOfIslands_PondSize {

    public static void main(String[] args) {

        int[][] grid =
                {
                        {1,1,1,1,0},
                        {1,1,0,1,0},
                        {1,1,0,0,0},
                        {0,0,0,0,0}
                };
        System.out.println(numberOfIslands(grid));

        int [][] grid1 = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };

        System.out.println(numberOfIslands(grid1));

    }

    static int numberOfIslands(int[][] grid){

        if(grid == null || grid.length == 0){
            return 0;
        }
        int numOfIslands = 0;

        for(int i = 0; i< grid.length;i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    numOfIslands += dfs(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }

    static int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);
        return 1;
    }
}

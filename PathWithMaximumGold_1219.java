//https://www.youtube.com/watch?v=8nlmcgy7vso
//https://leetcode.com/problems/path-with-maximum-gold/submissions/

public class PathWithMaximumGold_1219 {

    public static int checkGoldMine(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        int up = checkGoldMine(grid, i-1, j, visited);
        int down = checkGoldMine(grid, i+1, j, visited);
        int left = checkGoldMine(grid, i, j-1, visited);
        int right = checkGoldMine(grid, i, j+1, visited);
        visited[i][j] = false;
        
        return grid[i][j] + Math.max(left, Math.max(right, Math.max(up, down)));
    }
        
    public static int getMaximumGold(int[][] grid) {
    	
    	int max = 0;
    	
        for (int i=0; i<grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, checkGoldMine(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return max;
    }
    
	public static void main(String[] args) {
		int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
		System.out.println(getMaximumGold(grid));
	}

}

//https://www.lintcode.com/problem/bomb-enemy/
//https://www.youtube.com/watch?v=rMuGfUVkmTc

public class BombEnemy_553 {

	int max = 0;
	
	public int maxKilledEnemies2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int max = 0;
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            int rows = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int total = rows + cols[j];
                    for (int k = j + 1; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            total++;
                        }
                    }
                    for (int k = i + 1; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            total++;
                        }
                    }

                    max = Math.max(max, total);
                } else if (grid[i][j] == 'W') {
                    rows = 0;
                    cols[j] = 0;
                } else {
                    rows++;
                    cols[j]++;
                }
            }
        }

        return max;
    }

	public void maxEnemies(char[][] grid, int i, int j) {
		int t = 0;
		for (int a = i; a >= 0; a--) {
			char c = grid[a][j];
			if (c == 'W') {
				break;
			}
			if (c == 'E') {
				t++;
			}
		}

		for (int a = i + 1; a < grid.length; a++) {
			char c = grid[a][j];
			if (c == 'W') {
				break;
			}
			if (c == 'E') {
				t++;
			}
		}

		for (int a = j; a >= 0; a--) {
			char c = grid[i][a];
			if (c == 'W') {
				break;
			}
			if (c == 'E') {
				t++;
			}
		}

		for (int a = j + 1; a < grid[0].length; a++) {
			char c = grid[i][a];
			if (c == 'W') {
				break;
			}
			if (c == 'E') {
				t++;
			}
		}

		max = Math.max(max, t);
	}

	public int maxKilledEnemies(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					maxEnemies(grid, i, j);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		BombEnemy_553 enemy = new BombEnemy_553();
		char[][] grid = { { '0', 'E', '0', '0' }, 
						  { 'E', '0', 'W', 'E' }, 
						  { '0', 'E', '0', '0' } };
		
		System.out.println(enemy.maxKilledEnemies2(grid));
	}

}

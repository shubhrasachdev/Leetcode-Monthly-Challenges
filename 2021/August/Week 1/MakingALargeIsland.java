public class MakingALargeIsland {
    // August 1, 2021: Making a Large Island
    static int[] par, size;

    public static int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        par = new int[n * m];
        size = new int[n * m];
        int maxSize = 1;
        for(int i = 0; i < n * m; i++) {
            par[i] = i;
            size[i] = 1;
        }
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) {
                    for(int d = 0; d < dir.length; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                            int p1 = findPar(i * m + j), p2 = findPar(r * m + c);
                            if(p1 != p2) {
                                par[p1] = p2;
                                size[p2] += size[p1];
                                maxSize = Math.max(maxSize, size[p2]);
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    int currSize = 1;
                    HashSet<Integer> parents = new HashSet<>();
                    for(int d = 0; d < dir.length; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                            int p = findPar(r * m + c);
                            if(!parents.contains(p)) {
                                currSize += size[p];
                                parents.add(p);
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        return maxSize;        
    }
    
}

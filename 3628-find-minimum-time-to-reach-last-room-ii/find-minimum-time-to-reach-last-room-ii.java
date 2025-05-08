class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        pq.add(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], time = cur[2];
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            if (x == n - 1 && y == m - 1) {
                return time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    int nTime = Math.max(time + 1, moveTime[nx][ny]+1) + (x + y) % 2;
                    pq.add(new int[]{nx, ny, nTime});
                }
            }
        }
        
        return -1;
    }
}
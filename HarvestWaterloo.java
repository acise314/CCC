import java.io.*;
import java.util.*;

public class HarvestWaterloo {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        Character[][] grid = new Character[R][C];
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int smallCount = 0;
        int mediumCount = 0;
        int largeCount = 0;

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        Deque<Integer> nextX = new LinkedList<>();
        Deque<Integer> nextY = new LinkedList<>();
        nextX.add(A);
        nextY.add(B);
        visited[A][B] = true;
        while (!nextX.isEmpty()) {
            int x = nextX.poll();
            int y = nextY.poll();
            if (grid[x][y] == 'S') {
                smallCount++;
            } else if (grid[x][y] == 'M') {
                mediumCount++;
            } else if (grid[x][y] == 'L') {
                largeCount++;
            }
            if (x + 1 < R && !visited[x + 1][y] && grid[x + 1][y] != '*') {
                nextX.add(x + 1);
                nextY.add(y);
                visited[x + 1][y]=true;
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] != '*') {
                nextX.add(x - 1);
                nextY.add(y);
                visited[x - 1][y]=true;
            }
            if (y + 1 < C && !visited[x][y + 1] && grid[x][y + 1] != '*') {
                nextX.add(x);
                nextY.add(y + 1);
                visited[x][y + 1]=true;
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] != '*') {
                nextX.add(x);
                nextY.add(y - 1);
                visited[x][y - 1]=true;
            }
        }
        System.out.println(smallCount*1+mediumCount*5+largeCount*10);
    }
}

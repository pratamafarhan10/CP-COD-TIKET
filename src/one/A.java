package one;

public class A {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 1, 0, 0 ,0, 1},
                {0, 1, 1, 0 ,0, 0},
                {1, 1, 0, 1 ,1, 0},
                {0, 0, 0, 1 ,0, 1}
        };

        int[][] b = new int[][]{
                {1, 0, 0, 0 ,0, 1},
                {0, 1, 1, 0 ,0, 0},
                {1, 0, 0, 1 ,1, 0},
                {0, 0, 0, 1 ,0, 1}
        };

        System.out.println(countNumberOfBookedGroups(a));
        System.out.println(countNumberOfBookedGroups(b));
    }

    public static int countNumberOfBookedGroups(int[][] seats){
        int count = 0;

        // DFS
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0){
                    continue;
                }

                int curr = dfs(seats, i, j);
                if (curr > 0){
                    count++;
                }
            }
        }
        
        return count;
    }

    public static int dfs(int[][] seats, int row, int col){
        if (row == seats.length || seats[row].length == col || seats[row][col] == 0){
            return 0;
        }

        // the seats[row][col] == 1
        int groupOf = 1;
        seats[row][col] = 0;

        if (col != seats[row].length - 1 && seats[row][col+1] == 1){
            groupOf += dfs(seats, row, col+1);
        }

        if (row != seats.length - 1 && seats[row+1][col] == 1){
            groupOf += dfs(seats, row + 1, col);
        }

        if (col != 0 && seats[row][col-1] == 1){
            groupOf += dfs(seats, row, col-1);
        }

        return groupOf;
    }
}

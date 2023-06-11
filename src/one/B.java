package one;

import java.util.ArrayList;
import java.util.List;

public class B {
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

        countNumberOfBookedGroups(a, 3).forEach(System.out::println);
        countNumberOfBookedGroups(b, 3).forEach(System.out::println);
    }

    public static List<String> countNumberOfBookedGroups(int[][] seats, int n){
        List<String> res = new ArrayList<>();

        // DFS
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 1){
                    continue;
                }

                List<String> curr = dfs(seats, i, j);
                if ((res.isEmpty() || curr.size() < res.size()) && curr.size() >= n){
                    res = curr;
                }
            }
        }

        return res;
    }

    public static List<String> dfs(int[][] seats, int row, int col){
        System.out.println("\n===================");
        System.out.println("Current row: " + row);
        System.out.println("Current col: " + col);

        if (row == seats.length || seats[row].length == col || seats[row][col] == 1){
            return new ArrayList<>();
        }

        // the seats[row][col] == 1
        List<String> choices = new ArrayList<>();
        choices.add(row + " " + col);
        seats[row][col] = 1;

        if (col != seats[row].length - 1 && seats[row][col+1] == 0){
            choices.addAll(dfs(seats, row, col+1));
        }

        if (row != seats.length - 1 && seats[row+1][col] == 0){
            choices.addAll(dfs(seats, row + 1, col));
        }

        if (col != 0 && seats[row][col-1] == 0){
            choices.addAll(dfs(seats, row, col-1));
        }

        return choices;
    }
}

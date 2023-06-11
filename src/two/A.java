package two;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 3, 1, 2, 5, 1, 0, 1, 2};
        int[] b = new int[]{2, 0, 3, 1, 2, 5};

        System.out.println(holdWater(a));
        System.out.println(holdWater(b));
    }

    public static int holdWater(int[] bricks) {
        if (bricks.length == 0) {
            return 0;
        }

        int water = 0;

        List<Integer> stack = new ArrayList<>();
        stack.add(bricks[0]);

        for (int i = 1; i < bricks.length; i++) {
            stack.add(bricks[i]);

            if (bricks[i] > stack.get(0)) {
                for (int j = 1; j < stack.size() - 1; j++) {
                    water += stack.get(0) - stack.get(j);
                }
                stack = new ArrayList<>();
                stack.add(bricks[i]);
            }
        }

        if (!stack.isEmpty()) {
            for (int j = 1; j < stack.size() - 1; j++) {
                int block = stack.get(stack.size() - 1) - stack.get(j);
                if (block > 0) {
                    water += block;
                }
            }
        }

        return water;
    }
}

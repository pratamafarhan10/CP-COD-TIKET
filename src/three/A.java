package three;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 5, 6, 2, 2, 2, 2, 2, 2, 2, 1};
        int[] b = new int[]{3, 1, 5, 6, 2, 3, 1};
        int[] c = new int[]{3, 1, 5, 6, 2, 3, 1, 0, 6, 6, 6};

        System.out.println(findTheBiggestLand(a));
        System.out.println(findTheBiggestLand(b));
        System.out.println(findTheBiggestLand(c));
    }

    public static int findTheBiggestLand(int[] lands) {
        if (lands.length == 0) {
            return 0;
        }
        int kavling = 0;
        int highest = lands[0];

        // Find horizontally
//        List<Integer> horizontalStack = new ArrayList<>();
//        horizontalStack.add(lands[0]);
//        System.out.println("---- Horizontal");
//        for (int i = 1; i < lands.length; i++) {
//            System.out.println("Current lands: " + lands[i]);
//            if (horizontalStack.isEmpty() || horizontalStack.get(0) <= lands[i]) {
//                horizontalStack.add(lands[i]);
//            } else {
//                System.out.println("Current stack: " + horizontalStack);
//                int currKavling = horizontalStack.get(0) * horizontalStack.size();
//
//                if (currKavling > kavling) {
//                    kavling = currKavling;
//                }
//                System.out.println("Current kavling: " + kavling);
//                horizontalStack = new ArrayList<>();
//            }
//
//            if (lands[i] > highest) {
//                highest = lands[i];
//            }
//        }

        // Find the highest
        for (int i = 1; i < lands.length; i++) {
            if (lands[i] > highest){
                highest = lands[i];
            }
        }

        // Find vertically
        System.out.println("---- Vertical");
        List<Integer> verticalStack = new ArrayList<>();
        for (int i = 1; i <= highest; i++) {
            for (int j = 0; j < lands.length; j++) {
                if (lands[j] >= i) {
                    verticalStack.add(lands[j]);
                }

                if (j == lands.length - 1 || lands[j] < i) {
                    System.out.println("Current stack: " + verticalStack);
                    int currVertical = i * verticalStack.size();

                    if (currVertical > kavling) {
                        kavling = currVertical;
                    }
                    verticalStack = new ArrayList<>();
                }
            }
        }

        return kavling;
    }
}

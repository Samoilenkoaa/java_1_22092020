package lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr5 = {3, 4, 456, 3456, 432};
        System.out.println(maximum(arr5));
        System.out.println(minimum(arr5));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1})); // true
        System.out.println(checkBalance(new int[]{2, 1, 1, 2, 1})); // false
        shiftArray(new int[] {3,4,5,6,7}, 1);



//Задача № 1
        int[] arr1 = {0, 0, 0, 1, 1, 1};
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }
            System.out.print(Arrays.toString(arr1));
//ЗАДАЧА № 2
        int[] arr2 = new int[8];
        int b = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = b;
            System.out.print(arr2[i] + " ");
            b+=3;
        }
//ЗАДАЧА № 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6) {
               arr3[i] *= 2;
            }
            System.out.print(arr3[i] + " ");
        }
//ЗАДАЧА № 4
        int[][] arr4 = new int[6][6];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                if ((i == j) || (i == arr4.length - 1)) {
                    arr4[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    }
//ЗАДАЧА № 5
        static int maximum(int[] arr5) {
        int max = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if(arr5[i] > max) {
                max = arr5[i];
            }
        }
        return max;
    }

    static int minimum(int[] arr5) {
        int min = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if(arr5[i] < min) {
                min = arr5[i];
            }
        }
        return min;
    }
//ЗАДАЧА № 6
    static boolean checkBalance(int[] arr6) {
        int leftSum = 0;
        int rightSum = 0;

        for(int i = 1; i < arr6.length; i++) { // устанавливаем середину
            for(int j = 0; j < arr6.length; j++) {
                if (j < i) {
                    leftSum+= arr6[j];
                } else {
                    rightSum+= arr6[j];
                }
            }
            if (leftSum == rightSum) {
                return true;
            }
            leftSum = 0;
            rightSum = 0;
        }

        return false;

    }
// ЗАДАЧА № 7
    static void shiftArray(int[] arr, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                // Right
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                // Left
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}


package lesson5_advenced;

public class MethodsForArrays {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static float[] arr = new float[SIZE];
    private static float[] arr1 = new float[HALF_SIZE];
    private static float[] arr2 = new float[HALF_SIZE];

    public void runOneThread() {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Однопточный метод закончит свою работу через: " + (System.currentTimeMillis() - a));
    }

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }


    public void runTwoThreads() {
        for (int i = 1; i < arr.length; i++)
            arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        Thread t1 = new Thread(() -> {
            arr1 = calculate(arr1);
        });

        Thread t2 = new Thread(() -> {
            arr2 = calculate(arr2);
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Многопоточный метод закончит свою работу через: " + (System.currentTimeMillis() - a));
    }

}

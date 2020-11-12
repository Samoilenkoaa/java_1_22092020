package lesson2_advanced;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2 ", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };

        ArraySizeException(arr);

    }
    public static void ArraySizeException(String[][] array2) throws MyArraySizeException, MyArrayDataException {
        if (array2.length != 4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array2.length; i++) {
           if(array2[i].length !=4) {
               throw  new MyArraySizeException();
           }
        }
        int sum = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                try{
                    int element = Integer.parseInt(array2[i][j]);
                    sum += element;
                } catch (NumberFormatException e) {
                    System.out.println(sum);
                    throw  new MyArrayDataException("Ошибка данных в ячейке " + i + " " + j );
                }
            }
        }
        System.out.println(sum);

    }

}

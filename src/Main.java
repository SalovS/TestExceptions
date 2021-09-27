public class Main {
    public static void main(String[] args){
        String[][] arr1 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] arr2 = {{"1","2","3","4"},{"1","2","3","4"},{"1","7483642","3","4"},{"-483642","2","3","4"}};
        String[][] arr3 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] arr4 = {{"1","2","3","4"},{"1","2","3","4"},{"1","58","3","4"},{"1",null,"3","4"}};
        String[][] arr5 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2147483642","3","4"},{"1","2","3","4"}};
        String[][] arr6 = {{"-1","-2","-3","-4"},{"-1","-2","-3","-4"},{"-1","-2147483642","-3","-4"},{"1","2","3","4"}};
        String[][] arr7 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3"}};
        calculateNumbers(arr1);
        calculateNumbers(arr2);
        calculateNumbers(arr3);
        calculateNumbers(arr4);
        calculateNumbers(arr5);
        calculateNumbers(arr6);
        calculateNumbers(arr7);
    }

    private static boolean isCorrectSize(String[][] array){
        try {
            if(array.length != 4){
                throw new MyArraySizeException("Неподходящая мерность массива");
            }
            for(int i = 0; i < 4; i++){
                if(array[i].length != 4){
                        throw new MyArraySizeException("Размер строки " + i + " не равна 4");
                    }
                }
            }catch (MyArraySizeException e) {
            return false;
        }
        return true;
    }

    public static void calculateNumbers(String[][]array){
        if(isCorrectSize(array)) {
            int number = 0, sum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        number = Integer.valueOf(array[i][j]);
                    } catch (NumberFormatException e) {
                       new MayArrayDatAException("Указано неверное значение в массиве в ячейке " +
                                    "[" + i + "][" + j + "]");
                        return;
                    }
                    if (isCheckLimited(sum, number)) {
                        sum += number;
                    } else {
                        return;
                    }
                }
            }
            System.out.println("Сумма чисел матрицы : " + sum);
        }
    }

    private static boolean isCheckLimited(int sum, int number){
        if((sum >= 0 && number <= 0) || (sum <= 0 && number >= 0)) {
            return true;
        }else if(sum > 0 && number > 0 && Integer.MAX_VALUE - number > sum){
            return true;
        }else if(sum > 0 && number > 0 && Integer.MAX_VALUE - number > sum) {
            return true;
        }else{
            try {
                throw new MayArrayDatAException("Сумма чисел превышает размерность int");
            } catch (MayArrayDatAException e) {
                return false;
            }
        }
    }
}

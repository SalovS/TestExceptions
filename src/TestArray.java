public class TestArray {
    public void Start(String[][] array){
        try {
            if(checkSize(array)){
                try {
                    System.out.println("Сумма чисел матрицы : " + calculateNumbers(array));
                } catch (MayArrayDatAException e) {
                    e.printStackTrace();
                }
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private boolean checkSize(String[][] array) throws MyArraySizeException {
        if(array.length != 4){
            throw new MyArraySizeException("Неподходящая мерность массива");
        }
       for(int i = 0; i < 4; i++){
           if(array[i].length != 4){
               throw new MyArraySizeException("Размер строки " + i + " не равна 4");
           }
       }
       return true;
    }

    private int calculateNumbers(String[][]array) throws MayArrayDatAException {
        int number, summ = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                try{
                    number = Integer.valueOf(array[i][j]);
                }catch(NumberFormatException e){
                    throw new MayArrayDatAException("Указано неверное значение в массиве в ячейке " +
                            "[" + i + "][" + j + "]", e);
                }
                if(Integer.MAX_VALUE - number > summ){
                    summ += number;
                }else{
                    throw new MayArrayDatAException("Сумма чисел превышает размерность int");
                }
            }
        }
        return summ;
    }
}

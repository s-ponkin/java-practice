package Task1;

public class AddingArrays {

    public static void main(String[] args) {
        int[] numOne = {2,1,2,3,4};
        int[] numTwo = {1,9,2,3};

        int [] resultNum = addingNum(numOne, numTwo);

        for (int res : resultNum) {
            System.out.print(res);
        }
    }

    /**
     * Метод возвращает результат сложения двух чисел
     * @param numOne - первое число
     * @param numTwo - второе число
     * @return - результат сложения чисел
     */
    public static int[] addingNum(int[] numOne, int[] numTwo){
        int lenNumRes = 0;
        int resultNum= 0;

        if(numOne.length > numTwo.length) {lenNumRes = numOne.length + 1;}
        else {lenNumRes = numTwo.length + 1;}

        resultNum = transToNum(numOne) + transToNum(numTwo);
        int[] numRes = transToArr(resultNum, lenNumRes);

        if(numRes[0] != 0) {return numRes;}
        else {return delZero(numRes);}
    }

    /**
     * Метод переводит массив в число
     * @param arrNum - число в виде массива
     * @return - результат перевода массива в число
     */
    private static int transToNum(int[] arrNum){
        int result = 0;

        for (int i = 0; i < arrNum.length - 1; i++) {
            result += arrNum[i];
            result *= 10;
        }
        result += arrNum[arrNum.length - 1];
        return result;
    }

    /**
     * Метод переводит число в массив заданной длинны
     * @param Num - число, для перевода
     * @param sizeArr длина результирующего массива
     * @return - результирующий массив заданной длинны
     */
    private static int[] transToArr(int Num, int sizeArr){
        int[] numRes = new int[sizeArr];

        for (int i = 1; i < sizeArr + 1; i++) {
            numRes[sizeArr - i] = Num % 10;
            Num /= 10;
        }
        return numRes;
    }

    /**
     * Метод возвращает массив без лишних 0 в начале
     * @param num - число в виде массива для проверки на наличие лишних нулей
     * @return - результат удаления лишних нулей
     */
    private static int[] delZero(int[] num){
        if (num[0] == 0){
            int[] resArr = new int[num.length - 1];

            for (int i = 1; i < num.length; i++) {
                resArr[i - 1] = num[i];
            }
            return resArr;
        }
        else {return num;}
    }
}

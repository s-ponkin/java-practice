package Task1;

public class AddingArrays {

    public static void main(String[] args) {
        int[] numOne = {2, 1, 2, 3, 4, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] numTwo = {2, 1, 9, 2, 3};

        int[] resultNum = addingNum(numOne, numTwo);

        for (int res : resultNum) {
            System.out.print(res);
        }
    }

    /**
     * Метод возвращает результат сложения двух чисел
     *
     * @param numOne - первое число
     * @param numTwo - второе число
     * @return - результат сложения чисел
     */
    public static int[] addingNum(int[] numOne, int[] numTwo) {
        int lenNumRes = 0;
        int newNum = 0;
        int transfer = 0;
        int indexOne = numOne.length - 1;
        int indexTwo = numTwo.length - 1;

        if (numOne.length > numTwo.length) {
            lenNumRes = numOne.length;
            if (numOne[0] == 9) {
                lenNumRes++;
            }
        } else if (numOne.length < numTwo.length) {
            lenNumRes = numTwo.length;
            if (numTwo[0] == 9) {
                lenNumRes++;
            }
        } else {
            if (numOne[0] + numTwo[0] > 8) {
                lenNumRes++;
            }
        }

        int[] result = new int[lenNumRes];

        for (int i = lenNumRes - 1; i >= 0; i--) {

            if (indexOne < 0 && indexTwo < 0) {
                result[i] = transfer;
                break;
            }

            if (indexOne < 0) {
                newNum = numTwo[indexTwo] + transfer;
                if (newNum > 9) {
                    result[i] = newNum % 10;
                    transfer = newNum / 10;
                } else {
                    result[i] = numTwo[indexTwo] + transfer;
                    transfer = 0;
                }
            } else if (indexTwo < 0) {
                newNum = numOne[indexOne] + transfer;
                if (newNum > 9) {
                    result[i] = newNum % 10;
                    transfer = newNum / 10;
                } else {
                    result[i] = numOne[indexOne] + transfer;
                    transfer = 0;
                }
            } else {
                newNum = numOne[indexOne] + numTwo[indexTwo] + transfer;
                result[i] = newNum % 10;
                transfer = newNum / 10;
            }
            indexOne--;
            indexTwo--;
        }

        return delZero(result);
    }

    /**
     * Метод возвращает массив без лишних 0 в начале
     *
     * @param num - число в виде массива для проверки на наличие лишних нулей
     * @return - результат удаления лишних нулей
     */
    private static int[] delZero(int[] num) {
        if (num[0] == 0) {
            int[] resArr = new int[num.length - 1];

            for (int i = 1; i < num.length; i++) {
                resArr[i - 1] = num[i];
            }
            return resArr;
        } else {
            return num;
        }
    }
}

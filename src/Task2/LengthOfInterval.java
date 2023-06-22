package Task2;

public class LengthOfInterval {

    public static void main(String[] args) {
        int result = defineInterval("0111110111110111111011110");
        System.out.println(result);
    }

    /**
     * Метод вычисляет максимальный интервал 1 при удалении одного из элементов последовательности
     *
     * @param line - строка последовательности 0 и 1
     * @return - максимальный интервал 1
     */
    public static int defineInterval(String line) {
        char[] charLine = line.toCharArray();
        int oneCounter = 0;
        int nullCounter = 0;
        int amountAfterNull = 0;
        int amountBeforeNull = 0;
        int maxSequence = 0;
        boolean isNull = false;

        for (int i = 0; i < charLine.length; i++) {
            if (charLine[i] == '1') {
                oneCounter++;
                if (nullCounter == 1) {
                    if (i + 1 == charLine.length || charLine[i + 1] == '0') {
                        amountAfterNull = oneCounter;
                        if (amountAfterNull + amountBeforeNull > maxSequence) {
                            maxSequence = amountAfterNull + amountBeforeNull;
                            nullCounter = 0;
                        }
                    }
                } else {
                    if (oneCounter > maxSequence) {
                        maxSequence = oneCounter;
                    }
                    nullCounter = 0;
                }
            } else {
                isNull = true;
                amountBeforeNull = oneCounter;
                oneCounter = 0;

                if (oneCounter > maxSequence) {
                    maxSequence = oneCounter;
                }
                nullCounter++;
            }
        }
        if (isNull) {
            return maxSequence;
        } else {
            return maxSequence - 1;
        }
    }
}

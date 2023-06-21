package Task2;

import java.util.ArrayList;

public class LengthOfInterval {

    public static void main(String[] args) {
        int result = defineInterval("010010010111101101100100110");
        System.out.println(result);
    }

    /**
     * Метод вычисляет максимальный интервал 1 при удалении одного из элементов последовательности
     * @param line - строка последовательности 0 и 1
     * @return - максимальный интервал 1
     */
    public static int defineInterval(String line){
        ArrayList<Integer> numVal = new ArrayList<>();
        char[] charLine = line.toCharArray();
        char check = charLine[0];
        int count = 0;
        int maxSequence = 0;
        int sumAfterDelZero = 0;

        numVal.add(Character.getNumericValue(check));

        for (int i = 0; i < charLine.length; i++) {
            if(charLine[i] != check){
                numVal.add(count);
                if(count > maxSequence){maxSequence = count;}
                count = 1;
                numVal.add(Character.getNumericValue(charLine[i]));
                check = charLine[i];
            }
            else {count++;}
        }
        numVal.add(count);

        for (int i = 0; i < numVal.size() - 2; i += 2) {
            if(numVal.get(i) == 0 && i == 0){continue;}
            if(numVal.get(i) == 0 && numVal.get(i + 1) == 1){
                sumAfterDelZero = numVal.get(i - 1) + numVal.get(i + 3);
                if(sumAfterDelZero > maxSequence){maxSequence = sumAfterDelZero;}
            }
        }
        return maxSequence;
    }
}

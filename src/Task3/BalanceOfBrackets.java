package Task3;

public class BalanceOfBrackets {
    public static void main(String[] args) {
        System.out.println(checkBalance("10-((1+2*(34+23))+11)"));
    }

    /**
     * Метод вычисляет соблюдается ли баланс скобок
     * @param line - арифметическое выражение
     * @return - true - сбалансированно, false - несбалансированно
     */
    public static boolean checkBalance(String line){
        char[] charLine = line.toCharArray();
        int bracketFlag = 0;

        for (int i = 0; i < charLine.length; i++) {

            if(charLine[i] == '('){
                bracketFlag++;
            }
            else if(charLine[i] == ')'){
                bracketFlag--;
            }

        }

        if(bracketFlag != 0) {return false;}
        else {return true;}
    }
}

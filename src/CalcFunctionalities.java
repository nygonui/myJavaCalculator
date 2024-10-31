import java.util.ArrayList;
import java.util.Arrays;

public class CalcFunctionalities {
    private double rightValue;
    private double leftValue;
    private char operation;
    public double result;
    private CalcUI myCalcUI;

    CalcFunctionalities(CalcUI calcInterface){
        this.myCalcUI = calcInterface;
    }

    private void parseTextInValuesAndOperation(String text){
        String[] mySubString = text.split("[-+x/]");

        String leftValueStr = mySubString[0];
        String rightValueStr = mySubString[1];
        this.leftValue = Double.parseDouble(leftValueStr);
        this.rightValue = Double.parseDouble(rightValueStr);

        int operationSignalPosition;
        if(leftValue == rightValue){
            operationSignalPosition = text.lastIndexOf(rightValueStr)-1;
        }
        else {
            operationSignalPosition = text.indexOf(rightValueStr)-1;
        }
        this.operation = text.charAt(operationSignalPosition);
    }

    public void calculateTheResult(String text){
        this.parseTextInValuesAndOperation(text);
        this.result =  switch (this.operation){
            case '+' -> this.leftValue + this.rightValue;
            case '-' -> this.leftValue - this.rightValue;
            case 'x' -> this.leftValue * this.rightValue;
            case '/' -> this.leftValue / this.rightValue;
            default -> {
                System.out.println("Sinal da operação passada é inválido");
                yield 0.0;
            }
        };
    }

    public void deleteAll(){
        myCalcUI.setTextFieldValue("");
    }

    public void deleteLastChar(String text){
        if(text.isEmpty()){
            System.out.println("Is Empty");
            return;
        }

        char[] c = text.toCharArray();
        c[c.length-1] = ' ';
        String myNewStr = Arrays.toString(c);
        myNewStr = myNewStr.replaceAll("[\\[\\],]", "");
        myNewStr = myNewStr.replaceAll("[ ]", "");
        myCalcUI.setTextFieldValue(myNewStr);
    }

//    public void changePosivity(){}

//    public static void main(String[] args){
//        deleteLastChar("1234+789");
//    }
}

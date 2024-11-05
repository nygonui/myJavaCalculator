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
        this.leftValue = 0;
        this.rightValue = 0;
        this.operation = ' ';
    }

    public void setLeftValue(Double value){
        this.leftValue = value;
    }

    public void setRightValue(Double value){
        this.rightValue = value;
    }

    public void setOperation(String op){
        char[] opArr = op.toCharArray();
        this.operation = opArr[0];
    }

    private void setRightValue(String text){
        String[] mySubString = text.split("[-+x/]");

        if(mySubString[0].isEmpty())
            mySubString = Util.cleanFirstEmptyStringFromArrayString(mySubString);

        System.out.println(Arrays.toString(mySubString));
        String rightValueStr = mySubString[1];
        this.rightValue = Double.parseDouble(rightValueStr);
    }

    public void calculateTheResult(String text){
        System.out.println("Em calculateTheResult: " + text);
        this.setRightValue(text);
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
        this.leftValue = this.result;
        this.rightValue = 0;
        this.operation = ' ';
    }

    public void deleteAll(){
        myCalcUI.setTextFieldValue("");
        this.leftValue = 0;
        this.rightValue = 0;
        this.operation = ' ';
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

    public void changePositivity(String value){
        if(this.leftValue == 0 && this.rightValue == 0 ){
            double valueChanged = Double.parseDouble(value) * -1;
            myCalcUI.setTextFieldValue(Double.toString(valueChanged));
        }
        else if(this.leftValue != 0 && this.operation != ' '){
            String newValue;
            if(Util.checkIfTheRightValueExist(value)){
                setRightValue(value);
                this.rightValue *= -1;
                newValue = "" + this.leftValue + this.operation + this.rightValue;
                myCalcUI.setTextFieldValue(newValue);
            }
            else {
                // se tem leftValue, operation mas não tem rightValue
                this.leftValue *= -1;
                newValue = "" + this.leftValue + this.operation;
                myCalcUI.setTextFieldValue(newValue);
            }
        }
//        else if(this.rightValue == 0){
//            // separar o texto que recebemos para pegar apenas o valor da direita
//            System.out.println(value);
////            this.leftValue = Double.parseDouble(value) * -1;
//        }

    }

//    public static void main(String[] args){
//        deleteLastChar("1234+789");
//    }
}

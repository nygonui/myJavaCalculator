public class CalcFunctionalities {
    private String rightValueStr;
    private String leftValueStr;
    private char operation;
    public double result;
    private CalcInterface myCalcInterface;

    CalcFunctionalities(CalcInterface calcInterface){
        this.myCalcInterface = calcInterface;
    }

    public void init(String text){
        String[] mySubString = text.split("[-+x/]");

        this.leftValueStr = mySubString[0];
        this.rightValueStr = mySubString[1];
        double leftValue = Double.parseDouble(this.leftValueStr);
        double rightValue = Double.parseDouble(this.rightValueStr);

        int operationSignalPosition;
        if(leftValue == rightValue){
            operationSignalPosition = text.lastIndexOf(rightValueStr)-1;
        }
        else {
            operationSignalPosition = text.indexOf(rightValueStr)-1;
        }

        this.operation = text.charAt(operationSignalPosition);

        System.out.println(this.operation);

        this.result = calculateTheResult(leftValue, rightValue);
        System.out.println(this.result);
    }

    private double calculateTheResult(double leftValue, double rightValue){
        return switch (operation){
            case '+' -> leftValue + rightValue;
            case '-' -> leftValue - rightValue;
            case 'x' -> leftValue * rightValue;
            case '/' -> leftValue / rightValue;
            default -> {
                System.out.println("Sinal da operação passada é inválido");
                yield 0.0;
            }
        };
    }

    public void deleteAll(){
        myCalcInterface.setTextFieldValue("");
        this.rightValueStr = "";
        this.leftValueStr = "";
    }
}

import java.awt.*;
import java.awt.event.*;

public class CalcUI implements ActionListener {

    private final Frame frame = new Frame("Nygonui's Calc");
    private CalcFunctionalities myFunctionalities = new CalcFunctionalities(this);

    final int buttonDimension = 43;

    private final Button[] numbers = new Button[10];
    private final Button[] operations = new Button[6];
    private final Button[] otherButtons = new Button[3];
    private final TextField tf = new TextField();
    private String text = "";

    public CalcUI(){
        this.initNumbersButtons();
        this.initOperationsButtons();
        this.initOtherButtons();
        this.setBoundsForComponentsInterface();
        this.addListenersInAllKeys();

        this.frame.setSize(308, 421);
        this.addComponentsToScreen();

        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    private void initNumbersButtons(){
        for (int i = 0; i < this.numbers.length; i++){
            Button b = new Button(Integer.toString(i));
            this.numbers[i] = b;
        }
    }

    private void initOperationsButtons(){
        for (int i = 0; i < this.operations.length; i++){
            /*
            * operations[0] = Result (igual, "=")
            * operations[1] = Change Positivity ("+/-")
            * operations[2] = Add (soma, "+")
            * operations[3] = Subtraction (subtração, "-")
            * operations[4] = Multiplication (mutiplicação, "x")
            * operations[5] = Division (divisão, "/")
            * */
            this.operations[i] = switch (i){
                case 0 -> new Button("=");
                case 1 -> new Button("+/-");
                case 2 -> new Button("+");
                case 3 -> new Button("-");
                case 4 -> new Button("x");
                case 5 -> new Button("/");
                default -> new Button();
            };
        }
    }

    private void initOtherButtons(){
        /*
        * otherButtons[0] = decimal (".")
        * otherButtons[1] = delete last digit ("<x")
        * otherButtons[2] = delete all ("C")
        * */
        this.otherButtons[0] = new Button(".");
        this.otherButtons[1] = new Button("<x");
        this.otherButtons[2] = new Button("C");
    }

    private void setBoundsForComponentsInterface(){
        this.numbers[0].setBounds(103, 341, buttonDimension, buttonDimension);
        this.numbers[1].setBounds(43, 285, buttonDimension, buttonDimension);
        this.numbers[2].setBounds(103, 285, buttonDimension, buttonDimension);
        this.numbers[3].setBounds(163, 285, buttonDimension, buttonDimension);
        this.numbers[4].setBounds(43, 229, buttonDimension, buttonDimension);
        this.numbers[5].setBounds(103, 229, buttonDimension, buttonDimension);
        this.numbers[6].setBounds(163, 229, buttonDimension, buttonDimension);
        this.numbers[7].setBounds(43, 173, buttonDimension, buttonDimension);
        this.numbers[8].setBounds(103, 173, buttonDimension, buttonDimension);
        this.numbers[9].setBounds(163, 173, buttonDimension, buttonDimension);

        this.otherButtons[0].setBounds(163, 341, buttonDimension, buttonDimension);
        this.operations[0].setBounds(223, 285, 43, 99);
        this.operations[1].setBounds(42, 341, buttonDimension, buttonDimension);
        this.operations[2].setBounds(223, 229, buttonDimension, buttonDimension);
        this.operations[3].setBounds(223, 173, buttonDimension, buttonDimension);
        this.operations[4].setBounds(223, 117, buttonDimension, buttonDimension);
        this.operations[5].setBounds(163, 117, buttonDimension, buttonDimension);
        this.otherButtons[1].setBounds(103, 117, buttonDimension, buttonDimension);
        this.otherButtons[2].setBounds(43, 117, buttonDimension, buttonDimension);

        this.tf.setBounds(44, 37, 222, 54);
    }

    private void addComponentsToScreen(){
        // Add Buttons on Screen
        this.frame.add(this.numbers[0]);
        this.frame.add(this.numbers[1]);
        this.frame.add(this.numbers[2]);
        this.frame.add(this.numbers[3]);
        this.frame.add(this.numbers[4]);
        this.frame.add(this.numbers[5]);
        this.frame.add(this.numbers[6]);
        this.frame.add(this.numbers[7]);
        this.frame.add(this.numbers[8]);
        this.frame.add(this.numbers[9]);

        // Add other buttons
        this.frame.add(this.otherButtons[0]);
        this.frame.add(this.operations[0]);
        this.frame.add(this.operations[1]);
        this.frame.add(this.operations[2]);
        this.frame.add(this.operations[3]);
        this.frame.add(this.operations[4]);
        this.frame.add(this.operations[5]);
        this.frame.add(this.otherButtons[1]);
        this.frame.add(this.otherButtons[2]);

        // Add TextField on Screen
        this.frame.add(this.tf);
    }

    private void addListenersInAllKeys(){
        for(Button operation : this.operations){
            operation.addActionListener(this);
        }

        for(Button number: this.numbers){
            number.addActionListener(this);
        }

        for(Button otherButton: this.otherButtons){
            otherButton.addActionListener(this);
        }

    }

    public void setTextFieldValue(String text){
        this.text = text;
    }

    public void actionPerformed(ActionEvent e){
        if(Util.inOperationArray(e.getActionCommand())){
            double leftValue = Double.parseDouble(this.text); // transforma a string do valor em double
            myFunctionalities.setLeftValue(leftValue); // seta o valor esquerda la na classe de funcionalidades
            myFunctionalities.setOperation(e.getActionCommand()); // seta a operação matemática na classe de funcionalidades

            this.text += e.getActionCommand();
            this.tf.setText(this.text);
        }
        else if(e.getActionCommand().equals("=")){
            this.tf.setText("");
            myFunctionalities.calculateTheResult(this.text);
            this.tf.setText(Double.toString(myFunctionalities.result));
            this.text = Double.toString(myFunctionalities.result);
        }
        else if (e.getActionCommand().equals("C")){
            myFunctionalities.deleteAll();
            this.tf.setText(this.text);
        }
        else if(e.getActionCommand().equals("<x")){
            myFunctionalities.deleteLastChar(this.text);
            this.tf.setText(this.text);
        }
        else if(e.getActionCommand().equals("+/-")){
            myFunctionalities.changePositivity(this.text);
            this.tf.setText(this.text);
        }
        else {
            this.text += e.getActionCommand();
            this.tf.setText(this.text);
        }
    }
}
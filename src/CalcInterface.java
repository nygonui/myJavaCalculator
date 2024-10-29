import java.awt.*;
import java.awt.event.*;

public class CalcInterface implements ActionListener {

    private final Frame frame = new Frame();
    final int buttonDimension = 43;

    /*
    * TO-DO
    * [x] - Substituir as variáveis dos botões para array e criar métodos para inicializar eles se possível
    * [x] - Tentar substituir tudo o que se repete muitas vezes por laços, métodos e/ou arrays
    * [x] - Implementar uma variável que guarda os valores selecionados e display na tela esse valor
    * [] - Implementar as funcionalidades da calculadora
    * [] - Organizar melhor o códifo, aplicar melhor os conceitos de OOP (está tudo muito aqui, na classe da calculadora)
    * */

    private final Button[] numbers = new Button[10];
    private final Button[] operations = new Button[6];
    private final Button[] otherButtons = new Button[3];
    private final TextField tf = new TextField();
    private String text = "";

    public CalcInterface(){
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
            System.out.println(i);
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
        * otherButtons[0] = comma (",")
        * otherButtons[1] = delete last digit ("<x")
        * otherButtons[2] = delete all ("C")
        * */
        this.otherButtons[0] = new Button(",");
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
        int i = 0;
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

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("=")){
            PerformOperations p = new PerformOperations(this.text);
        }
        this.text += e.getActionCommand();
        this.tf.setText(this.text);
    }
}
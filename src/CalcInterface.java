import org.w3c.dom.Text;

import java.awt.*;

public class CalcInterface {

    final int width = 308;
    final int height = 421;

    private Frame frame = new Frame();
    final int buttonDimension = 43;
    Button b0 = new Button("0");
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button comma = new Button(",");
    Button opResult = new Button("=");
    Button opChangePositivity = new Button("+/-");
    Button opAdd = new Button("+");
    Button opSub = new Button("-");
    Button opMult = new Button("x");
    Button opDivi = new Button("/");
    Button actDeleteLastDigit = new Button("<x");
    Button actDeleteAll = new Button("C");

    TextField tf = new TextField();


    public CalcInterface(){
        this.b0.setBounds(103, 341, buttonDimension, buttonDimension);
        this.b1.setBounds(43, 285, buttonDimension, buttonDimension);
        this.b2.setBounds(103, 285, buttonDimension, buttonDimension);
        this.b3.setBounds(163, 285, buttonDimension, buttonDimension);
        this.b4.setBounds(43, 229, buttonDimension, buttonDimension);
        this.b5.setBounds(103, 229, buttonDimension, buttonDimension);
        this.b6.setBounds(163, 229, buttonDimension, buttonDimension);
        this.b7.setBounds(43, 173, buttonDimension, buttonDimension);
        this.b8.setBounds(103, 173, buttonDimension, buttonDimension);
        this.b9.setBounds(163, 173, buttonDimension, buttonDimension);

        this.comma.setBounds(163, 341, buttonDimension, buttonDimension);
        this.opChangePositivity.setBounds(42, 341, buttonDimension, buttonDimension);
        this.opResult.setBounds(223, 285, 43, 99);
        this.opAdd.setBounds(223, 229, buttonDimension, buttonDimension);
        this.opSub.setBounds(223, 173, buttonDimension, buttonDimension);
        this.opMult.setBounds(223, 117, buttonDimension, buttonDimension);
        this.opDivi.setBounds(163, 117, buttonDimension, buttonDimension);
        this.actDeleteLastDigit.setBounds(103, 117, buttonDimension, buttonDimension);
        this.actDeleteAll.setBounds(43, 117, buttonDimension, buttonDimension);

        this.tf.setBounds(44, 37, 222, 54);
    }

    public void init(){
        this.frame.setSize(this.width, this.height);

        // Add Buttons on Screen
        this.frame.add(this.b0);
        this.frame.add(this.b1);
        this.frame.add(this.b2);
        this.frame.add(this.b3);
        this.frame.add(this.b4);
        this.frame.add(this.b5);
        this.frame.add(this.b6);
        this.frame.add(this.b7);
        this.frame.add(this.b8);
        this.frame.add(this.b9);

        // Add other buttons
        this.frame.add(this.comma);
        this.frame.add(this.opChangePositivity);
        this.frame.add(this.opResult);
        this.frame.add(this.opAdd);
        this.frame.add(this.opSub);
        this.frame.add(this.opMult);
        this.frame.add(this.opDivi);
        this.frame.add(this.actDeleteLastDigit);
        this.frame.add(this.actDeleteAll);

        // Add TextField on Screen
        this.frame.add(this.tf);

        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
}



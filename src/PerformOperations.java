import java.lang.reflect.Array;
import java.util.Arrays;

public class PerformOperations {
    private String rightValue;
    private String leftValue;
    private String operation;

    PerformOperations(String text){
        String[] mySubString = text.split("/[+--/x]/");
        System.out.println(mySubString[0]);
    }
}

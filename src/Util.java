import java.util.Arrays;

public class Util {
    public static boolean inOperationArray(String text){
        String[] arr = {"+", "-", "x", "/"};
        boolean validation = false;
        for(String v : arr){
            if(v.equals(text)){
                validation = true;
                break;
            }
        }
        return validation;
    }

    public static String[] cleanFirstEmptyStringFromArrayString(String[] arr){
        String[] newStr = new String[arr.length-1];
        int i = 0;
        for(String st : arr){
            if(!st.isEmpty()){
                newStr[i-1] = st;
            }
            i++;
        }
        return newStr;
    }

    public static boolean checkIfTheRightValueExist(String text){
        String[] mySubString = text.split("[-+x/]");
        return mySubString.length > 1;
    }

    public static void main(String[] args){
        System.out.println(checkIfTheRightValueExist("2+"));
        System.out.println("-----");
        System.out.println(checkIfTheRightValueExist("-2+34"));
    }
}

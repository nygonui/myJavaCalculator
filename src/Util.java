public class Util {
    public static boolean inArray(String[] arr,String value){
        boolean validation = false;
        for(String v : arr){
            if(v.equals(value)){
                validation = true;
                break;
            }
        }
        return validation;
    }
}

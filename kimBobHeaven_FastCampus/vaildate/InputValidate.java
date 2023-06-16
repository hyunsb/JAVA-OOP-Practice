package kimBobHeaven_FastCampus.vaildate;

public class InputValidate {

    // 입력 값이 정수 값인지 검증하고 결과 값을 반환
    public static boolean isInteger(String inputValue){
        try { int integer = Integer.parseInt(inputValue);}
        catch (NumberFormatException exception) { return false;}
        return true;
    }



}

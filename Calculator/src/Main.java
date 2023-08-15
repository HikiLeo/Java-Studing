import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws ScannerException {

        String strResult = "";
        int intResult;
        String[] numbers;

        input = input.replaceAll("\\s","");

        if(input.indexOf( '+' )>0){
            numbers = input.split( "[+]" );
            if( numbers.length > 2){
                throw new ScannerException("Некоректно введено выражение.");
            }
            if(isArab(numbers[0]) && isArab(numbers[1])){
                strResult = String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
            } else if (isRim(numbers[0]) && isRim(numbers[1])) {
                strResult =  intToRim(rimToInt(numbers[0]) + rimToInt(numbers[1]));
            } else{
                throw new ScannerException("Некоректно введено выражение.");
            }
        } else if (input.indexOf( '-' )>0) {
            numbers = input.split( "-" );
            if( numbers.length > 2){
                throw new ScannerException("Некоректно введено выражение.");
            }
            if(isArab(numbers[0]) && isArab(numbers[1])){
                strResult = String.valueOf(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]));
            } else if (isRim(numbers[0]) && isRim(numbers[1])) {
                intResult = rimToInt(numbers[0]) - rimToInt(numbers[1]);
                if(intResult>0){
                    strResult =  intToRim(intResult);
                } else {
                    throw new ScannerException("Значение выражения не помещается в римскую систему счисления.");
                }

            } else{
                throw new ScannerException("Некоректно введено выражение.");
            }
        } else if (input.indexOf( '*' )>0) {
            numbers = input.split( "[*]" );
            if( numbers.length > 2){
                throw new ScannerException("Некоректно введено выражение.");
            }
            if(isArab(numbers[0]) && isArab(numbers[1])){
                strResult = String.valueOf(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));
            } else if (isRim(numbers[0]) && isRim(numbers[1])) {
                strResult =  intToRim(rimToInt(numbers[0]) * rimToInt(numbers[1]));
            } else{
                throw new ScannerException("Некоректно введено выражение.");
            }
        }else if (input.indexOf( '/' )>0) {
            numbers = input.split( "/" );
            if( numbers.length > 2){
                throw new ScannerException("Некоректно введено выражение.");
            }
            if(isArab(numbers[0]) && isArab(numbers[1])){
                strResult = String.valueOf(Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]));
            } else if (isRim(numbers[0]) && isRim(numbers[1])) {
                intResult = rimToInt(numbers[0]) / rimToInt(numbers[1]);
                if(intResult>0){
                    strResult =  intToRim(intResult);
                } else {
                    throw new ScannerException("Значение выражения не помещается в римскую систему счисления.");
                }
            } else{
                throw new ScannerException("Некоректно введено выражение.");
            }
        }else {
            throw new ScannerException("Некоректно введено выражение.");
        }

        return strResult;
    }

    private static boolean isArab(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean isRim(String str){
        for(RimNum x: RimNum.values()){
            if (x.name().equals(str)){
                return true;
            }
        }
        return false;
    }

    private static int rimToInt(String str){
        int count = 0;
        for(RimNum x: RimNum.values()){
            if(x.name().equals(str)){
                count = x.getCount();
            }
        }
        return count;
    }

    private static String intToRim(int count){
        if (count == 100){
            return "C";
        }
        String rim = "";
        String i = "";
        int n = 0;
        while (count > 0) {
            for (RimNum x : RimNum.values()) {
                if(count < x.getCount()){
                    break;
                }
                i = x.name();
                n = x.getCount();
            }
            rim += i;
            count -=  n;
        }


        return rim;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getPowArray(int length) {
        int BASE = 2;
        List<Integer> powArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            powArray.add((int) Math.pow(BASE, i));
        }
        return powArray;
    }
    public static int getDecimalValue(String binary, List<Integer> powArray) {
        int sum = 0;
        for (int i = 0, j = binary.length() - 1; i < binary.length(); i++, j--) {
            if (binary.charAt(j) == '1') {
                sum += powArray.get(i);
            }
        }
        return sum;
    }
    public static String getBinary(int decimal) {
        String binary = "";
        int binaryLength = getBinaryLength(decimal);
        List<Integer> powArray = getPowArray(binaryLength);
        for (int i = binaryLength - 1; i >= 0; i--) {
            if (decimal >= powArray.get(i)) {
                binary += "1";
                decimal -= powArray.get(i);
            } else {
                binary += "0";
            }
        }
        return binary;
    }
    public static int getBinaryLength(int decimal) {
        int length = 0;
        while (decimal > 0) {
            decimal /= 2;
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        String binary = "1001";
        List<Integer> powArray = getPowArray(binary.length());
        int decimal = getDecimalValue(binary, powArray);
        System.out.println(decimal);
        System.out.println(getBinary(decimal));
    }
}

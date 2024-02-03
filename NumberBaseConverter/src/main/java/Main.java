import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getPowersArray(int base, int length) {
        List<Integer> powArray = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            powArray.add((int) Math.pow(base, i));
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
        List<Integer> powArray = getPowersArray(2, binaryLength);
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
    public static String getHexFromNumber(int number) {
        if (number < 10) {
            return String.valueOf(number);
        } else {
            return String.valueOf((char) (number + 55));
        }
    }
    public static List<String> getSubBinaryArray(String binary, int length) {
        List<String> subBinaryArray = new ArrayList<>();
        if (binary.length() % length != 0) {
            int remainder = binary.length() % length;
            for (int i = 0; i < length - remainder; i++) {
                binary = "0" + binary;
            }
        }
        for (int i = 0; i < binary.length(); i += length) {
            subBinaryArray.add(binary.substring(i, i + length));
        }
        return subBinaryArray;
    }
    public static String getHexFromBinary(String binary) {
        List<String> subBinaryArray = getSubBinaryArray(binary, 4);
        String hex = "";
        for (String subBinary : subBinaryArray) {
            int decimalValue = getDecimalValue(subBinary, getPowersArray(2, subBinary.length()));
            hex += getHexFromNumber(decimalValue);
        }
        return hex;
    }
    public static int getOctalFromBinary(String binary) {
        List<String> subBinaryArray = getSubBinaryArray(binary, 3);
        String octal = "";
        for (String subBinary : subBinaryArray) {
            int decimalValue = getDecimalValue(subBinary, getPowersArray(2, subBinary.length()));
            octal += decimalValue;
        }
        int octalNum = Integer.parseInt(octal);
        return octalNum;
    }
    public static int getDecimalFromBase(int number, int base) {
        int decimal = 0;
        String numberString = String.valueOf(number);
        int length = numberString.length();
        List<Integer> powArray = getPowersArray(base, length);
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            decimal += Integer.parseInt(String.valueOf(numberString.charAt(j))) * powArray.get(i);
        }
        return decimal;
    }
    public static void main(String[] args) {
        String binary = "11111001";
        List<Integer> powArrayBinary = getPowersArray(2, binary.length());
        int decimal = getDecimalValue(binary, powArrayBinary);
        System.out.println(decimal);
        System.out.println(getBinary(decimal));
        System.out.println(getHexFromBinary(binary));
        System.out.println(getOctalFromBinary(binary));
        int decimalFromBase4 = getDecimalFromBase(123, 4);
        System.out.println(decimalFromBase4);
    }
}

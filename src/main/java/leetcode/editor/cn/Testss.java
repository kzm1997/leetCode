package leetcode.editor.cn;

public class Testss {

    public static void main(String[] args) {
        byte[] bytes = convertHexToBytes("");
    }

    public static byte[] convertHexToBytes(String value) {
        int len = value.length() / 2;
        byte[] ret = new byte[len];
        for (int i = 0; i < len; i++) {
            ret[i] = (byte) (Integer.parseInt(value.substring(i * 2, (i + 1) * 2), 16));
        }
        return ret;
    }
}

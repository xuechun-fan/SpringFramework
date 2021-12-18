package com.fxc.shirodemo.utils;

/**
 * @author FXC  2021年12月18日 14:27
 */
public class EqualsUtils {

    /**
     * 比对两个字节数组是否内容一致
     *
     * @param digesta
     * @param digestb
     * @return
     */
    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta == digestb) {
            return true;
        }
        if (digesta == null || digestb == null) {
            return false;
        }

        int lenA = digesta.length;
        int lenB = digestb.length;

        if (lenB == 0) {
            return lenA == 0;
        }

        int result = 0;
        result |= lenA - lenB;

        // time-constant comparison
        for (int i = 0; i < lenA; i++) {
            // If i >= lenB, indexB is 0; otherwise, i.
            int indexB = ((i - lenB) >>> 31) * i;
            result |= digesta[i] ^ digestb[indexB];
        }
        return result == 0;
    }
}

package leetcode;

import sun.rmi.server.InactiveGroupException;

public class HammingDistance {

    public static int bitCount(int var0) {
        System.out.println(Integer.toBinaryString(var0));
        var0 -= var0 >>> 1 & 1431655765;
        System.out.println(var0);
        var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
        var0 = var0 + (var0 >>> 4) & 252645135;
        var0 += var0 >>> 8;
        var0 += var0 >>> 16;
        return var0 & 63;
    }

    public static int hammingDistance(int x, int y) {
        return bitCount(x^y);
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
//        System.out.println(hd.hammingDistance(1,4));
//        System.out.println(bitCount(-3));
        System.out.println(bitCount(15));
    }
}

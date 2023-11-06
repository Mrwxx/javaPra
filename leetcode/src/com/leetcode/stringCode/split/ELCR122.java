package com.leetcode.stringCode.split;

/**
 * @author Mr.wxx
 * @create 2023-10-22-16:06
 **/
public class ELCR122 {
    public static void main(String[] args) {
        ELCR122 elcr122 = new ELCR122();
        elcr122.pathEncryption("a.aef.qerf.bb");
    }
    public String pathEncryption(String path) {

        // 特殊情况
        if(path == null || path.length() == 0){
            return path;
        }
        int len = path.length();
        String[] split = path.split("/.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            if(i != split.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

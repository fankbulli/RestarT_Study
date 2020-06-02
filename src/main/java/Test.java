import java.util.HashMap;

/**
 * @program: Restart_Study
 * @description: 无
 * @author: zhongming
 * @time: 2020/6/2 9:46
 */

public class Test {
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
    HashMap hashMap=new HashMap();

    public static void main(String[] args) {
        System.out.println(tableSizeFor(79));;
    }
}

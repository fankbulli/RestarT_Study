package Java_Basic.map;

import java.util.HashMap;

/**
 * @program: Restart_Study
 * @description: hashmap方法测试类
 * @author: zhongming
 * @time: 2020/6/2 14:00
 */

public class HashMapMain {
    final static int MAXIMUM_CAPACITY=1<<30;
    public static void main(String[] args) {
        System.out.println(tableSizeFor(362));
    }

    /**
    * @Description: hashmap 的返回一个大于输入参数且最小的为2的n次幂的数
    * @Param: 
    * @return: 
    * @Author: zhongming
    * @Date: 2020/6/2
    */
    public static final int tableSizeFor(int c){
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}

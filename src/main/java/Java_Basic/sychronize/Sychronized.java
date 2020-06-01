package Java_Basic.sychronize;

import Java_Basic.serialize.Student;

/**
 * @program: Restart_Study
 * @description: sychronized学习类
 * @author: zhongming
 * @time: 2020/6/1 16:02
 */

public class Sychronized {
    /**
    * @Description: 修饰实例方法 锁对象
    * @Param:
    * @return:
    * @Author: zhongming
    * @Date: 2020/6/1
    */
    public synchronized void husbandFunction(){}

    /**
    * @Description: 修饰代码块 锁类
    * @Param:
    * @return:
    * @Author: zhongming
    * @Date: 2020/6/1
    */
    public void husbandClass(){
        synchronized (Sychronized.class){

        }
    }
    /**
    * @Description: 修饰一个枷锁对象，锁对象
    * @Param:
    * @return:
    * @Author: zhongming
    * @Date: 2020/6/1
    */
    public void husbandObject(){
        synchronized (new Student()){

        }
    }
}

package Java_Basic.serialize;

import java.io.*;

/**
 * @program: Restart_Study
 * @description: 序列化测试类
 * @author: zhongming
 * @time: 2020/6/1 14:50
 */

public class SerializeTest {
    public static void main(String[] args) {
        try {
            serialize();
//            deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * @Description: 序列化生成文件
    * @Param: 
    * @return: 
    * @Author: zhongming
    * @Date: 2020/6/1
    */
    public static void serialize() throws IOException {

        Student student = new Student();
        student.setName("CodeSheep");
        student.setAge( 18 );
        student.setScore( 1000 );

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("src\\main\\java\\Java_Basic\\serialize\\student.txt") ) );
        objectOutputStream.writeObject( student );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
    }
    /**
    * @Description: 序列化生成对象
    * @Param: 
    * @return: 
    * @Author: zhongming
    * @Date: 2020/6/1
    */
    public static void deserialize(  ) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("src\\main\\java\\Java_Basic\\serialize\\student.txt") ) );
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( student );
    }
}

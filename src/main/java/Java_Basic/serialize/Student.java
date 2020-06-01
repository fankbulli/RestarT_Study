package Java_Basic.serialize;

import java.io.Serializable;

/**
 * @program: Restart_Study
 * @description: 测试实体类--学生
 * @author: zhongming
 * @time: 2020/6/1 14:50
 */

public class Student implements Serializable {
    public final Long  serialVersionUID = 5793714892044641611L;
    private String name;
    private Integer age;
    private transient Integer score;
    //类一旦改变信息，系统自己给的序列化id会变，原来得序列化文件不能反序列化
    private Long studentId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student:" + '\n' +
                "name = " + this.name + '\n' +
                "age = " + this.age + '\n' +
                "score = " + this.score + '\n'
                ;
    }
}

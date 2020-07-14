import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        Calendar cal=Calendar.getInstance();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);



    }
//    public static void main(String[] args) {
//        //1、普通的时间转换
//        String string = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
//        System.out.println(string);
//        System.out.println("-------------------------------");
//        //2、日历类的时间操作
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String d="2038-01-01";
//        try {
//            Date date=sdf.parse(d);
//            System.out.println(System.currentTimeMillis());
//            System.out.println(date.getTime());
//            calendar.setTime(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println();
//    }

}

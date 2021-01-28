import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

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
        //str写在循环外面
        String str="";

        String input="\"钟鸣\",\"爱\",\"朱佳佳\"";
        //去掉首尾的""
        str=input.substring(1,input.length()-1);
        //分隔
        String[] strings=str.split("\",\"");
        for (String s:strings){
            System.out.println(s);
        }


//        System.out.println(tableSizeFor(79));;
//
//        Calendar cal=Calendar.getInstance();
//        int day=cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(day)；
//        BigDecimal b=new BigDecimal("0.90004");
//        BigDecimal c= b.multiply(new BigDecimal("100"));
//        DecimalFormat df1 = new DecimalFormat("0.00");
//
//        String str = df1.format(c)+"%";
//
//
//        System.out.println(str);
//

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        List<HousingFundPayRecord> list= null;
//        try {
//            list = Arrays.asList(
//              new HousingFundPayRecord(sdf.parse("2020-06-30")),
//              new HousingFundPayRecord(sdf.parse("2020-03-30")),
//              new HousingFundPayRecord(sdf.parse("2020-09-30")),
//              new HousingFundPayRecord(sdf.parse("2020-11-30")),
//              new HousingFundPayRecord(sdf.parse("2020-01-30"))
//            );
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        //按时间排序，最新的在第一个
//        List<HousingFundPayRecord> result=list.stream().sorted(Comparator.comparing(HousingFundPayRecord::getDate).reversed()).collect(Collectors.toList());
//        //顺序输出
//        result.forEach(e->{
//            System.out.println(sdf.format(e.getDate()));
//        });
//
//        Collections.sort(list,new Ss());
    }

}
class Ss implements Comparator<HousingFundPayRecord>{

    @Override
    public int compare(HousingFundPayRecord o1, HousingFundPayRecord o2) {
        return 0;
    }

}
class HousingFundPayRecord {
    Date date;

    public HousingFundPayRecord(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
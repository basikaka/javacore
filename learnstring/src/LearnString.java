import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class LearnString {
    public static boolean equals( StringBuffer sb1, StringBuffer sb2){
        if (sb1 == sb2) {
            return  true;
        }
        if (sb1 == null || sb2 == null) {
            return  false;
        }

        if (sb1.length() != sb2.length()) {
            return false;
        }else {
            boolean aBoolean = true;
            for (int i = 0; i < sb1.length(); i++) {
                if(sb1.charAt(i) != sb2.charAt(i))
                    aBoolean = false;
            }
            return aBoolean;
        }



    }

    static int factorial(int n) {
        int f;

        for(f = 1; n > 1; n--){
            f *= n;
        }
        return f;
    }
    static int ncr(int n,int r) {
        return factorial(n) / ( factorial(n-r) * factorial(r) );
    }

    public static void main(String []args){
        String a = "a";
        String b = "b";
        // 这里的a + b应该是放在堆里的对象，常量池没有
        String c = a + b;
        // 这里的a + b应该是放在常量池里面的
        String d = "a" + "b";
        // 经测试，发现只要有使用引用变量a加上一个常量池内容"xxx"或者引用变量，都会放在堆里
        String e = a + "b";
        // 注意intern()返回的是常量池中字符串的引用，而不是堆中字符串的引用
        String f = c.intern();
        String g = "ab";
        String h = new String("ab");

        System.out.println(a + b == "ab");  // false
        System.out.println(c == "ab");      // false
        System.out.println(c == a + b);     // false
        System.out.println(c == h);         // false
        System.out.println(c == f);         // false
        System.out.println(d == e);         // false
        System.out.println(d == f);         // true
        System.out.println(d == g);         // true
        System.out.println(f == g);         // true


        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);


        StringBuffer buf = new StringBuffer("hello");
        buf.append("_java");
        System.out.println(buf);

        StringBuilder build = new StringBuilder("hello");
        build.append("_java");
        System.out.println(build);

//比较 StringBuffer 和 String 的性能
        Date d1 = new Date();
        Long date_a = d1.getTime();
        for (int i = 0; i < 100000; i++) {
            //str1 += i;
        }
        Date d2 = new Date();
        Long date_b = d2.getTime();
        System.out.println( date_b - date_a);

        Date d3 = new Date();
        date_a = d3.getTime();
        for (int i = 0; i < 100000; i++) {
            //buf.append(i);
        }
        Date d4 = new Date();
        date_b = d4.getTime();
        System.out.println( date_b - date_a);

        // 比较两个 StringBuffer 的内容是否相等，使用 toString 或者不使用
        StringBuffer  strbuf_a = new StringBuffer("Hello_Java_EE");
        StringBuffer  strbuf_b = new StringBuffer("Hello_Java_EE");


        StringBuffer sb_a = new StringBuffer();
        StringBuffer sb_b = new StringBuffer();
        for (int i = 0; i < 10000; i++){
            sb_a.append(i);
            sb_b.append(i);
        }

        System.out.println("********* 不使用 toString **********");
        System.out.println(sb_a.equals( sb_b ));


        System.out.println("********* 使用 toString **********");
        date_a = new Date().getTime();
        System.out.println(strbuf_a.toString().equals(strbuf_b.toString()));
        date_b = new Date().getTime();
        System.out.println(date_b - date_a);

        System.out.println("********* 使用自定义 equals() **********");
        date_a = new Date().getTime();
        System.out.println(equals(sb_a, sb_b));
        date_b = new Date().getTime();
        System.out.println(date_b - date_a);

        //System.out.println("请输入一个数字：");
        /*
        Scanner sca = new Scanner(System.in);
        int ainput = sca.nextInt();
        System.out.println(ainput);
        */

        // 声明并初始化int数组
        int[] numbers = { 43, 32, 53, 54, 75, 7, 10 };
        System.out.println("----for each----");
        // for-each语句
        for (int item : numbers) {
            System.out.println("Count is:" + item);
        }


        // 声明并初始化string数组
        String[] urls = { "http://douban.cn" , "http://github.com", "https://python.org", "https://facebook.com" };
        System.out.println("----for each----");
        // for-each语句
        for (String item : urls) {
            System.out.println("link-address:" + item);
        }

        //比较 next() 和 nextline() 方法的异同点。

        Scanner insca = new Scanner(System.in);
        /*System.out.println("请输入你的姓名：");
        String name = insca.nextLine();
        System.out.println("你年龄：");
        int age = insca.nextInt();
        System.out.println("你的薪水：");
        float sara = insca.nextFloat();
        System.out.println("信息如下：");
        System.out.println( name + " " + age + " " + sara);
         */
/*
        System.out.println("你年龄：");
        int age1 = insca.nextInt();
        insca.nextLine();
        System.out.println("请输入你的姓名：");
        String name_1 = insca.nextLine();
        System.out.println("你的薪水：");
        float sara1 = insca.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println( name_1 + " " + age1 + " " + sara1);

 */

/*
        //break 中断、跳出for循环结构
        boolean complete = true;
        System.out.println("开始体能测试.");
        for(int i = 1; i<10; i++){
            System.out.println("你已经跑了"+ i + "圈了。");
            System.out.println("还要再跑一圈吗？（y/n）");
            String answer = insca.nextLine();
            if( answer.equals("n")|| answer.equals("N")){
                System.out.println("你已经退出了体能测试。");
                complete = false;
                break;
            }
        }
        if(complete ){
            System.out.println("太棒了，你已经完成所有体能测试项目了。");
        }
*/

        //continue 测试
        label1:for (int x = 0; x < 5; x++) {
            for (int y = 5; y > 0; y--) {
                //if(y == 1)
                //    continue label1;
                System.out.println(x + " " + y);
            }
        }

        //pascals triangle


        int n, i, j;
        n = 5;
        for(i = 0; i<=n; i++){
            for (j = 0; j <= n - 1; j++) {
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print(" "+ ncr(i, j));
            }
            System.out.println();
        }
    }
}

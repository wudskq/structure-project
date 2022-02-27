/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021年11月27日 03:30:00
 */

public class Test {
    public static void main(String[] args) {
        process(17,3);
    }

    private static int process(int a,int b){
        int c = a%b;
        System.out.println(c);
        return c;
    }
}

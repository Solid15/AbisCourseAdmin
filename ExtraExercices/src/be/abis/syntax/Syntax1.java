package be.abis.syntax;

public class Syntax1 {

    public static void main(String[] args) {

        int abc;
        int _under_bar_;
        int m928134;
        int t5;
        int j7;
        int her_sales$;
        int var;
        /*
        int 9qdf;
        int me@var;
        int transient;
        int some#;
        int if;
        */

        byte b = -128;
        char ch = 5;

        int x;
        char c = 'c';
        x=c;

        float e = 5;
     //   float f = 5.0;
        double d = 5;
        float fl = (float)d;
        long l = 6;
        long l1 = 12345;
        long l2 = 123_456_789;
        int i = (int)l1;

        int i1 = 012;               //  =  10
        System.out.println(i1);
        i = 0x12_E;                 // 302
        System.out.println(i);

        x = 7 + 3*6/4 -1;           // 10
        System.out.println(x);

        x = 5%3 + 2*4 -3/2;         //  9     (why not 8?)   (resrterende breuk = 2; niet delen zelf)
        System.out.println(x);
        x = (3*9*(3-(9*3/3)));      // -162
        System.out.println(x);

        System.out.println("6"+(5+3*6));

  //      byte v = 5; byte w = 6; byte u = v+w;
        int m = 5; int n = 6; n += m;
        int k = m++ + ++n;
        System.out.println(k);    //  17?   !!

        boolean b0 = false;
        System.out.println(b0=false);       // false
        System.out.println(5!=4?6:3);       // 6







    }
}

package be.abis.syntax;

public class SyntaxWhile {

    public static void main(String... args) {
    /*    int i = 5;
        while (i<=10) {                 //  5 7 9
            System.out.println(i); i+=2;
        }
        System.out.println();

        i = 5;
        do {                                    //  5     (>6 !=  >=6)
            System.out.println(i); i++;
        } while (i>6);
        System.out.println();

        i = 5;
  //      while (i<=10) System.out.println(i); i+=2;          //  loop of 5

        String s = "b";
  /*      do {
            System.out.println("not b");            // "not b"  ==>> does not compile (no boolean value in while)
            s = "c";
        } while (s = "b");
*/

        for (int i=0; i<=5; i+=2) System.out.println(i);        // 0 2 4
        for (int i=0; i<=5;) {
            System.out.println(i); i+=2;                        // 0 2 4
        }
        for (int i=1; i<3; i++) {
            for (int j=5; j>0;j--) {                    // 15 14 13 12 11 10 25 24 23 22 21 20 35    WRONG
                System.out.println(i + "" + j);         //   ==>>  15 14 13 12 11 25 24 23 22 21
            }
        }

        System.out.println();
        for (int i=1; i<3; i++) {
            for (int j=5; j>0; j--) {                   // 15 14 13 12 25 24 23
                if (i==j) break;
                System.out.println(i + "" + j);
            }
        }

        System.out.println();
        for (int i=1; i<3; i++) {
            for (int j=5; j>0; j--) {                   // 15 14 13 12 ??
                if (i==j) continue;                     // ==>>  15 14 13 12 25 24 23 21
                System.out.println(i + "" + j);
            }
        }
        System.out.println();

        outerloop:
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i*j>4) {
                    System.out.println("Breaking"); break outerloop;
                }
                System.out.println(i+""+j);
            }                                                   // 00 01 02 10 11 12 20 21 22
        }
        System.out.println("Done");

        System.out.println();
        String[] table = {"aa", "bb", "cc", "dd"};
        for (String ss: table) {
            if ("bb".equals(ss)){
                continue;
            }
            System.out.println(ss);
            if ("cc".equals(ss)){
                break;                                      // aa     ==>>  aa cc
            }
        }

   /*     int[] b =  new int[10];
        for (int i=0; i<= b.length; i++) b[i] = 1;          // out of bounds   (b.length - 1)

        int[][] a = {{1,2},{3,4}};
        a[1,1] = 5;                                         // a[1][1]
   */

        String[] a  = new String[3];
        a[1] = "this"; a[2] = "is"; a[0] = "fixing";
        for (String s:a) {
            System.out.println(s.toUpperCase());        // THIS IS   => nullpointer exception
        }

        String[][] aa = {{"this", "is", "an"},{"array"}}; {
            System.out.println(aa[1][0]);                           //  "array"
        }

        String aaa[] = new String[3];
        a[0] = "e11";
        a[1] = "e12";
        System.out.println(aaa.length);               //length for array, length() for string

  /*      int[] arr[] = new int[2][];                   // possible, but int[][] arr or int arr[][] is better
        arr[0] = new int[] {1,2,3};
        arr[1] = {5,2};                                 // no array initializer here
        System.out.println(arr[0][1] == arr[1][0]);
    */
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;
        arr2[1] = 4;
        for (int i=0; i<arr1.length; i++) {
            System.out.println(arr1[i]);                    // 1 4 3   VV
        }

        System.out.println();
        String s = "testing java strings";
        System.out.println(s.charAt(1));                    // e
   //     System.out.println(s.append(" 123"));                // doesn't compile
        System.out.println(s.indexOf("s",2));   //  3 ??   => 2
        System.out.println(s.equals("testing java String"));    // false
        System.out.println(s.substring(3,6));           // ting  ??     =>   tin
        System.out.println(s.concat("again").toUpperCase().replace("T","o").substring(4,7));
                                                        // oESoING JAVA SoRINGSAGAIN =>  "ING"

        System.out.println();
        s = "hello";
        s.concat(" again");
        System.out.println(s + " my friend"); // hello my friend

        System.out.println();
        s+= " again";
        System.out.println(s.length());   // hello again    =>  11     length()  gives an int  !!!!!

        s= "hello";
        s+= " again".toUpperCase();
    //    System.out.println(s.reverse());   // unknown method
        
    }
}

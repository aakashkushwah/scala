package lectures.part1basics;

import java.util.Scanner;

public class JPlayBook {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String bs = Integer.toBinaryString(n);
        int result = Integer.MIN_VALUE;
        int count =0;
        for (int i = 0; i < bs.length(); i++) {

            if (bs.charAt(i) == '0')
                count = 0;
            else
            {
                count++;//increase count
                result = Math.max(result, count);
            }
        }
        System.out.print(result);
        scanner.close();
    }


}

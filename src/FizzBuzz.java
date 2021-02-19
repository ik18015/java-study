public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
//            System.out.print("joc");
//            System.out.println(i);
//            System.out.println(i % 3);
//            System.out.println(i % 5);
//            System.out.println(i % 3 == 0 && i % 5 == 0);
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}




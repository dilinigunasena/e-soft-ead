import java.util.Scanner;

public class Test {
    public void myinput(){
        Scanner myscan = new Scanner(System.in);
        System.out.print("Enter your name :");
        String name = myscan.nextLine();
        System.out.print("Name is "+name);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.myinput();
    }
}

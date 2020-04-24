import java.util.Scanner;

public class DemoMainClass {
    public static void main(String args[]) {
        Scanner inScanner = new Scanner(System.in);
        System.out.println("Enter input file path and name");
        String inFile = inScanner.next();
        System.out.println("you entered" + inFile);
        System.out.println("Enter output file path and name");
        String outFile = inScanner.next();
        FileStrategyContext context = new FileStrategyContext(inFile, outFile);
        context.createOutput();
    }
}

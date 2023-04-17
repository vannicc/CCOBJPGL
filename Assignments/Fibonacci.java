import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        // Prompt user to input desired range of the sequence
        System.out.print("Enter range: ");
        int range = scan.nextInt();
        
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.println("Fibonacci sequence up to " + range + " term/s:");
        for (int i = 0; i < range; i++) {
           System.out.print(firstTerm + " ");

           int nextTerm = firstTerm + secondTerm;
           firstTerm = secondTerm;
           secondTerm = nextTerm;
        }

        scan.close();
    }
}

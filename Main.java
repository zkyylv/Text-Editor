import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = "";
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();

        while (true) {
            String cmd = sc.nextLine().trim();

            if (cmd.equals("show")) {
                System.out.println(current);
            } else if (cmd.equals("undo")) {
                if (!undo.isEmpty()) {
                    redo.push(current);
                    current = undo.pop();
                }
            } else if (cmd.equals("redo")) {
                if (!redo.isEmpty()) {
                    undo.push(current);
                    current = redo.pop();
                }
            } else if (cmd.startsWith("write ")) {
                undo.push(current);
                redo.clear();
                current += cmd.substring(6);
            } else if (cmd.equals("exit")) {
                break;
            }
        }
    }
}

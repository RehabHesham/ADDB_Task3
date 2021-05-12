import java.util.Scanner;

public class StringsInitials {
    static Scanner sc=new Scanner(System.in);

    public static void main(String [] args) {
         do{
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            if (name.contains("0"))
                break;
            StringInitials(name);
        }while (true);
    }

    static void StringInitials(String name){
        if (name.length() == 0)
            return;

        System.out.print(Character.toUpperCase(
                name.charAt(0)));

        for (int i = 1; i < name.length() - 1; i++)
            if (name.charAt(i) == ' ')
                System.out.print(" " + Character.toUpperCase(
                        name.charAt(i + 1)));
            System.out.println("");
        return;
    }
}

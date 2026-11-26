import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 3 digits of a bank account: ");
        String prefix = input.nextLine();

        Scanner file = new Scanner(
                URI.create("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt").toURL().openStream(), "Cp852");

        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] fields = line.split("\t");
            if (fields[0].trim().startsWith(prefix)) {
                System.out.println("Bank name: " + fields[1].trim());
                return;
            }
        }
        System.out.println("Bank not found");
    }
}

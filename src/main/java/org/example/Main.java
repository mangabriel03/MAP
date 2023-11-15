package org.example;

import java.util.Scanner;

import org.example.ui.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("               Muzica              ");
            System.out.println("===================================");
            System.out.println("1. Album ");
            System.out.println("2. Concert ");
            System.out.println("3. Fan ");
            System.out.println("4. Manager ");
            System.out.println("5. Membru Trupa ");
            System.out.println("6. Merchandise ");
            System.out.println("7. Piesa ");
            System.out.println("8. Trupa ");
            System.out.println("9. Turneu ");
            System.out.println("10. Iesire");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    AlbumUI.main(new String[]{});
                    break;
                case 2:
                    ConcertUI.main(new String[]{});
                    break;
                case 3:
                    FanUI.main(new String[]{});
                    break;
                case 4:
                    ManagerUI.main(new String[]{});
                    break;
                case 5:
                    MembruTrupaUI.main(new String[]{});
                    break;
                case 6:
                    MerchandiseUI.main(new String[]{});
                    break;
                case 7:
                    PiesaUI.main(new String[]{});
                    break;
                case 8:
                    TrupaUI.main(new String[]{});
                    break;
                case 9:
                    TurneuUI.main(new String[]{});
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}


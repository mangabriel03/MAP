//package UI;
//
//import domain.Melodie;
//import domain.MelodieFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Scanner;
//@RestController
//
//public class MelodieAppUI {
//    @Autowired
//    private MelodieFactory melodieFactory = new MelodieFactory();
//    //private  Scanner scanner;
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public MelodieAppUI(MelodieFactory melodieFactory1) {
//        this.melodieFactory = melodieFactory1;
//    }
//
//    public static void main(String[] strings) {
//        boolean running = true;
//
//        while (running) {
//            System.out.println("===================================");
//            System.out.println("               Melodie             ");
//            System.out.println("===================================");
//            System.out.println("1. Creare Single");
//            System.out.println("2. Creare Cover");
//            System.out.println("3. Creare Original");
//            System.out.println("4. Iesire");
//            System.out.print("Alegeti comanda: ");
//
//            Scanner scanner = new Scanner(System.in);
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    createMelodie("Single");
//                    break;
//                case 2:
//                    createMelodie("Cover");
//                    break;
//                case 3:
//                    createMelodie("Original");
//                    break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid");
//            }
//        }
//    }
//
//    private static void createMelodie(String melodieType) {
//        System.out.print("Introduceti Numele Melodiei " + melodieType + ": ");
//        //Scanner scanner = new Scanner(System.in);
//        String numeMelodie = scanner.nextLine();
//        Melodie melodie = melodieFactory.createMelodie(melodieType, numeMelodie);
//        System.out.println("Melodie " + melodieType + " creata: " + melodie.afiseazaDetalii());
//    }
//}

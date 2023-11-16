package UI;

import domain.Turneu;
import domain.Concert;
import repository.inMemoryRepo.TurneuRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TurneuUI {
    private static final TurneuRepo turneuRepo = new TurneuRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("              Turneu               ");
            System.out.println("===================================");
            System.out.println("1. Creaza Turneu");
            System.out.println("2. Toare Turneele");
            System.out.println("3. Actualizeaza Turneu");
            System.out.println("4. Sterge Turneu");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createTurneu();
                    break;
                case 2:
                    viewAllTurnee();
                    break;
                case 3:
                    updateTurneu();
                    break;
                case 4:
                    deleteTurneu();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid ");
            }
        }
    }

    private static void createTurneu() {
        System.out.print("Nume Turneu: ");
        String turneuName = scanner.nextLine();

        System.out.print("Data de Incepere (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr);

        System.out.print("Data de sarsit (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr);

        System.out.print("Locatia: ");
        String location = scanner.nextLine();

        List<Concert> concerte = new ArrayList<>();  // You can implement this part according to your needs

        Turneu createdTurneu = turneuRepo.createTurneu(turneuName, startDate, endDate, location, concerte);
        System.out.println("Turneu creat cu ID: " + createdTurneu.getIdTurneu());
    }

    private static void viewAllTurnee() {
        List<Turneu> turnee = turneuRepo.getAllTurnee();
        for (Turneu turneu : turnee) {
            System.out.println(turneu);
        }
    }

    private static void updateTurneu() {
        System.out.print("Introduceti ID-ul Turneului pentru actualizare: ");
        int turneuId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Turneu existingTurneu = turneuRepo.getTurneuById(turneuId);
        if (existingTurneu == null) {
            System.out.println("Turneu nu a ost gasit.");
            return;
        }

        System.out.print("Noul Nume al Turneului: ");
        String turneuName = scanner.nextLine();

        System.out.print("Noua Data de Incepere(yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr);

        System.out.print("Noua Data de Sfarsit (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr);

        System.out.print("Noua Locatie: ");
        String location = scanner.nextLine();

        List<Concert> concerte = new ArrayList<>();  // You can implement this part according to your needs

        Turneu updatedTurneu = new Turneu(turneuId, turneuName, startDate, endDate, location, concerte);
        turneuRepo.updateTurneu(updatedTurneu);
        System.out.println("Turneu actualizata cu succes.");
    }

    private static void deleteTurneu() {
        System.out.print("Introduceti ID-ul Trupei pentru stergere: ");
        int turneuId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        turneuRepo.removeTurneu(turneuId);
        System.out.println("Turneu stergere cu succes.");
    }
}

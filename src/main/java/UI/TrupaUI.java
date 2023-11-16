package UI;

import domain.Trupa;
import repository.inMemoryRepo.TrupaRepo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TrupaUI {
    private static final TrupaRepo trupaRepo = new TrupaRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("               Trupa               ");
            System.out.println("===================================");
            System.out.println("1. Creaza Trupa");
            System.out.println("2. Toate Trupele");
            System.out.println("3. Actualizeaza Trupa");
            System.out.println("4. Sterge Trupa");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createTrupa();
                    break;
                case 2:
                    viewAllTrupe();
                    break;
                case 3:
                    updateTrupa();
                    break;
                case 4:
                    deleteTrupa();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void createTrupa() {
        System.out.print("Numele Trupei: ");
        String bandName = scanner.nextLine();

        System.out.print("ID-ul Managerului: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        System.out.print("Anul infintarii Trupei: ");
        int formationYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Trupa createdTrupa = trupaRepo.createTrupa(bandName, managerId, formationYear);
        System.out.println("Trupa creata cu ID: " + createdTrupa.getIdTrupa());
    }

    private static void viewAllTrupe() {
        List<Trupa> trupe = trupaRepo.getAllTrupe();
        for (Trupa trupa : trupe) {
            System.out.println(trupa);
        }
    }

    private static void updateTrupa() {
        System.out.print("Introduceti ID-ul Trupei pentru actualizare: ");
        int trupaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Trupa existingTrupa = trupaRepo.getTrupaById(trupaId);
        if (existingTrupa == null) {
            System.out.println("Trupa nu a fost gasita.");
            return;
        }

        System.out.print("Noul Nume al Trupei: ");
        String bandName = scanner.nextLine();

        System.out.print("Noul Manager al Trupei: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        System.out.print("Noul an al Infintarii Trupei: ");
        int formationYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Trupa updatedTrupa = new Trupa(trupaId, bandName, managerId, formationYear);
        trupaRepo.updateTrupa(updatedTrupa);
        System.out.println("Trupa actualiztata cu succes");
    }

    private static void deleteTrupa() {
        System.out.print("Introduceti ID-ul Trupei pentru stergere: ");
        int trupaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        trupaRepo.removeTrupa(trupaId);
        System.out.println("Trupa stearsa cu succes.");
    }
}


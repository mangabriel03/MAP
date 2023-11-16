package UI;

import domain.Piesa;
import repository.inMemoryRepo.PieseRepo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PieseUI {
    private static final PieseRepo pieseRepo = new PieseRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("               Piese               ");
            System.out.println("===================================");
            System.out.println("1. Creaza Piesa");
            System.out.println("2. Toate Piesele");
            System.out.println("3. Actualizeaza Piesa");
            System.out.println("4. Sterge Piesa");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createPiesa();
                    break;
                case 2:
                    viewAllPiese();
                    break;
                case 3:
                    updatePiesa();
                    break;
                case 4:
                    deletePiesa();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    private static void createPiesa() {
        System.out.print("Titlu: ");
        String title = scanner.nextLine();

        System.out.print("Durata: ");
        float duration = scanner.nextFloat();
        scanner.nextLine();  // Consume newline character

        Piesa createdPiesa = pieseRepo.createPiesa(title, duration);
        System.out.println("Piesa creata cu ID: " + createdPiesa.getIdPiesa());
    }

    private static void viewAllPiese() {
        List<Piesa> piese = pieseRepo.getAllPiese();
        for (Piesa piesa : piese) {
            System.out.println(piesa);
        }
    }

    private static void updatePiesa() {
        System.out.print("Introduceti ID-ul Piesei pentru actualizare: ");
        int piesaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Piesa existingPiesa = pieseRepo.getPiesaById(piesaId);
        if (existingPiesa == null) {
            System.out.println("Piesa nu a fost gasita.");
            return;
        }

        System.out.print("Noul Titlu: ");
        String title = scanner.nextLine();

        System.out.print("Durata noua: ");
        float duration = scanner.nextFloat();
        scanner.nextLine();  // Consume newline character

        Piesa updatedPiesa = new Piesa(piesaId, title, duration);
        pieseRepo.updatePiesa(updatedPiesa);
        System.out.println("Piesa actualizata cu succes.");
    }

    private static void deletePiesa() {
        System.out.print("Introduceti ID-ul Piesei pentru stergere: ");
        int piesaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        pieseRepo.removePiesa(piesaId);
        System.out.println("Piesa sters cu succes.");
    }
}

package org.example.ui;


import org.example.domain.Merchandise;
import org.example.repository.inMemoryRepo.MerchandiseRepo;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MerchandiseUI {
    private static final MerchandiseRepo merchandiseRepo = new MerchandiseRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("               Merch               ");
            System.out.println("===================================");
            System.out.println("1. Creaza Merchandise");
            System.out.println("2. Toate Merchandise");
            System. out.println("3. Actualizare Merchandise");
            System.out.println("4. Sterge Merchandise");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createMerchandise();
                    break;
                case 2:
                    viewAllMerchandise();
                    break;
                case 3:
                    updateMerchandise();
                    break;
                case 4:
                    deleteMerchandise();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void createMerchandise() {
        System.out.print("Numele Produsului: ");
        String productName = scanner.nextLine();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        System.out.print("Pret: ");
        float price = scanner.nextFloat();
        scanner.nextLine();  // Consume newline character

        System.out.print("ID-ul Trupa: ");
        int bandId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Merchandise createdMerchandise = merchandiseRepo.createMerchandise(productName, stock, price, bandId);
        System.out.println("Merchandise creata cu ID: " + createdMerchandise.getIdProdus());
    }

    private static void viewAllMerchandise() {
        List<Merchandise> merchandiseList = merchandiseRepo.getAllMerchandise();
        for (Merchandise merchandise : merchandiseList) {
            System.out.println(merchandise);
        }
    }

    private static void updateMerchandise() {
        System.out.print("Introduceti ID-ul Merchandiseului pentru actualizare: ");
        int merchandiseId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Merchandise existingMerchandise = merchandiseRepo.getMerchandiseById(merchandiseId);
        if (existingMerchandise == null) {
            System.out.println("Merchandise nu a fost gasit.");
            return;
        }

        System.out.print("Nume nou: ");
        String productName = scanner.nextLine();

        System.out.print("Stock nou: ");
        int stock = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        System.out.print("Pretul nou: ");
        float price = scanner.nextFloat();
        scanner.nextLine();  // Consume newline character

        Merchandise updatedMerchandise = new Merchandise(merchandiseId, productName, stock, price, existingMerchandise.getIdTrupa());
        merchandiseRepo.updateMerchandise(updatedMerchandise);
        System.out.println("Merchandise actualizat cu succes.");
    }

    private static void deleteMerchandise() {
        System.out.print("INtroduceti ID-ul Merchandiseului pentru stergere: ");
        int merchandiseId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        merchandiseRepo.removeMerchandise(merchandiseId);
        System.out.println("Merchandise sters cu succes.");
    }
}
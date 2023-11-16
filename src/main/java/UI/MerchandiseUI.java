package UI;


import domain.AdaugaAdaosPretStrategy;
import domain.AplicaDiscountPretStrategy;
import domain.Merchandise;
import domain.PretStrategy;
import repository.inMemoryRepo.MerchandiseRepo;

import java.net.SocketOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import repository.inMemoryRepo.MerchandiseRepoStrategy;


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
            System.out.println("5. Actualizare Merchandise with Strategy");
            System.out.println("6. Inapoi");
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
                    updateMerchandiseStrategy();
                case 6:
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

        System.out.print("IdTrupa: ");
        int trupId = scanner.nextInt();


        Merchandise merchandise = new Merchandise(merchandiseId, productName, stock, price, trupId);

        merchandiseRepo.updateMerchandise(merchandise);
        System.out.println("Merchandise actualizat cu succes.");
        System.out.println(merchandise);

    }

    private static void updateMerchandiseStrategy(){
        System.out.println("Introduceti strategia(adaos/discount)");
        String strategy = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Introduceti ID-ul Merchandiseului pentru actualizare: ");
        int merchandiseId = scanner.nextInt();
        scanner.nextLine();

        Merchandise existingMerchandise = merchandiseRepo.getMerchandiseById(merchandiseId);
        if (existingMerchandise == null) {
            System.out.println("Merchandise nu a fost gasit.");
            return;
        }

        System.out.println("Introduceti procentul pentru discount/adaos");
        int procent = scanner.nextInt();
        scanner.nextLine();

        System.out.println("pana aci dupa citiri");

        Merchandise merchandise = new Merchandise(merchandiseId, existingMerchandise.getNumeProdus(), existingMerchandise.getStoc(), existingMerchandise.getPret(), existingMerchandise.getIdTrupa());

        if (strategy.equals("discount")){
            PretStrategy pretStrategy = new AplicaDiscountPretStrategy(procent);
            MerchandiseRepoStrategy merchandiseRepoStrategy = new MerchandiseRepoStrategy(pretStrategy);
            merchandise = merchandiseRepoStrategy.applyPretStrategy(merchandise);
            System.out.println(merchandise);
        }
        else if (strategy.equals("adaos")) {
            MerchandiseRepoStrategy merchandiseRepoStrategy = new MerchandiseRepoStrategy(new AdaugaAdaosPretStrategy(existingMerchandise.getPret()));
            merchandise = merchandiseRepoStrategy.applyPretStrategy(merchandise);
            System.out.println(merchandise);
        }


    }

    private static void deleteMerchandise() {
        System.out.print("INtroduceti ID-ul Merchandiseului pentru stergere: ");
        int merchandiseId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        merchandiseRepo.removeMerchandise(merchandiseId);
        System.out.println("Merchandise sters cu succes.");
    }
}

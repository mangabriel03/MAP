package UI;

import domain.MembruTrupa;
import repository.inMemoryRepo.MembruTrupaRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MembruTrupaUI {
    private static final MembruTrupaRepo membruTrupaRepo = new MembruTrupaRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("           Membru Trupa            ");
            System.out.println("===================================");
            System.out.println("1. Creaza Membru Trupa");
            System.out.println("2. Toti Membri Trupa");
            System.out.println("3. Actualizare Membru Trupa");
            System.out.println("4. Sterge Membru Trupa");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createMembruTrupa();
                    break;
                case 2:
                    viewAllMembriTrupa();
                    break;
                case 3:
                    updateMembruTrupa();
                    break;
                case 4:
                    deleteMembruTrupa();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void createMembruTrupa() {
        System.out.print("NUme: ");
        String firstName = scanner.nextLine();

        System.out.print("Prenume: ");
        String lastName = scanner.nextLine();

        System.out.print("Data nasterii (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

        System.out.print("ID-ul TRupei: ");
        int bandId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        MembruTrupa createdMembruTrupa = membruTrupaRepo.createMembruTrupa(firstName, lastName, dateOfBirth, bandId);
        System.out.println("Membru Trupa creat cu ID: " + createdMembruTrupa.getIdMembru());
    }

    private static void viewAllMembriTrupa() {
        List<MembruTrupa> membriTrupa = membruTrupaRepo.getAllMembrii();
        for (MembruTrupa membruTrupa : membriTrupa) {
            System.out.println(membruTrupa);
        }
    }

    private static void updateMembruTrupa() {
        System.out.print("Introduceti ID-ul Membrului Trupa pentru actualizare: ");
        int membruTrupaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        MembruTrupa existingMembruTrupa = membruTrupaRepo.getMembruById(membruTrupaId);
        if (existingMembruTrupa == null) {
            System.out.println("Membru Trupa nu a fost gasit.");
            return;
        }

        System.out.print("Numa nou: ");
        String firstName = scanner.nextLine();

        System.out.print("Prenume nou: ");
        String lastName = scanner.nextLine();

        System.out.print("Noua Data de nastere (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

        MembruTrupa updatedMembruTrupa = new MembruTrupa(membruTrupaId, firstName, lastName, dateOfBirth, existingMembruTrupa.getIdTrupa());
        membruTrupaRepo.updateMembruTrupa(updatedMembruTrupa);
        System.out.println("Membru Trupa actualizat cu succes.");
    }

    private static void deleteMembruTrupa() {
        System.out.print("Introduceti ID-ul Membrului Trupa pentru a fi sters: ");
        int membruTrupaId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        membruTrupaRepo.removeMembruTrupa(membruTrupaId);
        System.out.println("Membru Trupa sters cu succes.");
    }
}

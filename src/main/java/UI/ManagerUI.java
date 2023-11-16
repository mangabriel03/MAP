package UI;

import domain.Manager;
import repository.inMemoryRepo.ManagerRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUI {
    private static final ManagerRepo managerRepo = new ManagerRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("             Manager               ");
            System.out.println("===================================");
            System.out.println("1. Creare Manager");
            System.out.println("2. Toti Manageri");
            System.out.println("3. Actualizare Manager");
            System.out.println("4. Sterge Manager");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createManager();
                    break;
                case 2:
                    viewAllManagers();
                    break;
                case 3:
                    updateManager();
                    break;
                case 4:
                    deleteManager();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void createManager() {
        System.out.print("Nume: ");
        String firstName = scanner.nextLine();

        System.out.print("Prenume: ");
        String lastName = scanner.nextLine();

        System.out.print("Data nasterii (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

        Manager createdManager = managerRepo.createManager(firstName, lastName, dateOfBirth);
        System.out.println("Manager creat cu ID: " + createdManager.getIdManager());
    }

    private static void viewAllManagers() {
        List<Manager> managers = managerRepo.getAllManageri();
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }

    private static void updateManager() {
        System.out.print("Introduceti ID-ul Managerului pentru actualizare: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        Manager existingManager = managerRepo.getManagerById(managerId);
        if (existingManager == null) {
            System.out.println("Managerul nu a fost agsit.");
            return;
        }

        System.out.print("Numele nou: ");
        String firstName = scanner.nextLine();

        System.out.print("Prenumele nou: ");
        String lastName = scanner.nextLine();

        System.out.print("Noua Data de nastere (yyyy-MM-dd): ");
        String dateOfBirthStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

        Manager updatedManager = new Manager(managerId, firstName, lastName, dateOfBirth);
        managerRepo.updateManager(updatedManager);
        System.out.println("Manager a fost actualizat cu succes.");
    }

    private static void deleteManager() {
        System.out.print("Introduceti ID-ul Managerului pentru a fi sters: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        managerRepo.removeManager(managerId);
        System.out.println("Manager a fost sters cu succes.");
    }
}

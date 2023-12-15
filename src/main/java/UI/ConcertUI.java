package UI;

import ObserverLogic.ConcertObserver;
import ObserverLogic.EvenimentObserver;
import ObserverLogic.Observer;
import RepoDB.ConcertRepoDB;
import domain.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import repository.inMemoryRepo.ConcertRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
@RestController

public class ConcertUI {
    @Autowired
    private static ConcertRepoDB concertRepo ;

    private Observer observer = new Observer();
    private static final EvenimentObserver concertObserver = new ConcertObserver();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //concertRepo.adaugaObserver(concertObserver);
        boolean running = true;

        while (running) {
            System.out.println("===================================");
            System.out.println("              Concert              ");
            System.out.println("===================================");
            System.out.println("1. Creare Concert");
            System.out.println("2. Toate Concertele");
            System.out.println("3. Actualizare Concert");
            System.out.println("4. Sterge Concert");
            System.out.println("5. Observa observarii");
            System.out.println("6. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createConcert();
                    break;
                case 2:
                    viewAllConcerts();
                    break;
                case 3:
                    //updateConcert();
                    break;
                case 4:
                    //deleteConcert();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void createConcert() {
        System.out.print("Introduceti Data (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.print("Introduceti Nume: ");
        String name = scanner.nextLine();

        System.out.print("Introduceti ID-ul TRupei: ");
        int bandId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        System.out.print("Introduceti Locatie: ");
        String location = scanner.nextLine();
        //Concert createdConcert = concertRepo.createConcert(date, name, bandId, location);
        //System.out.println("Concert creat cu ID: " + createdConcert.getIdConcert());
    }

    private static void viewAllConcerts() {
        List<Concert> concerts = concertRepo.findAll();
        for (Concert concert : concerts) {
            System.out.println(concert);
        }
    }

//    private static void updateConcert() {
//        System.out.print("Introduceti ID-ul Concertului pentru actualizare: ");
//        int concertId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        Concert existingConcert = concertRepo.getConcertById(concertId);
//        if (existingConcert == null) {
//            System.out.println("Concertul nu a fost gasit.");
//            return;
//        }
//
//        System.out.print("Introduceti data noua (yyyy-MM-dd): ");
//        String dateStr = scanner.nextLine();
//        LocalDate date = LocalDate.parse(dateStr);
//
//        System.out.print("Introduceti Nume nou: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Introduceti ID-ul nou a Trupei: ");
//        int bandId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        System.out.print("Introduceti locatie noua: ");
//        String location = scanner.nextLine();
//
//        Concert updatedConcert = new Concert(concertId, date, name, bandId, location);
//        concertRepo.updateConcerte(updatedConcert);
//        System.out.println("Concert actualizat cu succes.");
//    }
//
//    private static void deleteConcert() {
//        System.out.print("Introduceti ID-ul Concertului pentru a fii sters: ");
//        int concertId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        concertRepo.removeConcert(concertId);
//        System.out.println("Concert sters cu succes.");
//    }
}

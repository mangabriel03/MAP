package UI;

import RepoDB.AlbumRepoDB;
import domain.Album;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import repository.inMemoryRepo.AlbumRepo;

import java.time.LocalDate;
import java.util.*;

//import org.springframework.shell.starter.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDate;
import java.util.Scanner;
@Getter
//@ComponentScan(basePackages = {"UI"})
@RestController
public class AlbumUI {
   @Autowired
    private  AlbumCommands albumCommands;
    private static final Scanner scanner = new Scanner(System.in);

//    public static AlbumCommands getAlbumCommands() {
//        if (albumCommands == null) {
//            albumCommands = new AlbumCommands();
//        }
//        return albumCommands;
//    }

    public static void main(String[] args) {
        boolean running = true;
        AlbumUI aUI = new AlbumUI();
        while (running) {
            System.out.println("===================================");
            System.out.println("               Album               ");
            System.out.println("===================================");
            System.out.println("1. Creare Album");
            System.out.println("2. Toate Albumele");
            System.out.println("3. Actualizare Album");
            System.out.println("4. Sterge Album");
            System.out.println("5. Inapoi");
            System.out.print("Alegeti comanda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Introduceti ID-ul Artistului: ");
                    int artistId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character

                    System.out.print("Introduceti Titlul: ");
                    String title = scanner.nextLine();

                    System.out.print("Introduceti Data Lansarii (yyyy-MM-dd): ");
                    String releaseDateStr = scanner.nextLine();
                    LocalDate releaseDate = LocalDate.parse(releaseDateStr);
                    String created = aUI.getAlbumCommands().createAlbum(artistId,title,releaseDateStr);
                    System.out.println(created);
                    break;
                case 2:
                    aUI.getAlbumCommands().viewAllAlbums();
                    break;
                case 3:
                    //aUI.getAlbumCommands().updateAlbum();
                    break;
                case 4:
                    //deleteAlbum();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }





//    private static void createAlbum() {
//        System.out.print("Introduceti ID-ul Artistului: ");
//        int artistId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        System.out.print("Introduceti Titlul: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Introduceti Data Lansarii (yyyy-MM-dd): ");
//        String releaseDateStr = scanner.nextLine();
//        LocalDate releaseDate = LocalDate.parse(releaseDateStr);
//
//        //Album createdAlbum = albumRepo.createAlbum(artistId, title, releaseDate);
//        //System.out.println("Album creat cu ID: " + createdAlbum.getIdAlbum());
//    }
//
//    private static void viewAllAlbums() {
//        List<Album> albums = albumRepo.findAll();
//        for (Album album : albums) {
//            System.out.println(album);
//        }
//    }

//    private static void updateAlbum() {
//        System.out.print("Introduceti ID-ul Albumului pentru actualizare: ");
//        int albumId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        Album existingAlbum = albumRepo.getAlbumById(albumId);
//        if (existingAlbum == null) {
//            System.out.println("Albumul nu a fost gasit.");
//            return;
//        }
//
//        System.out.print("Introduceti ID-ul Artistului: ");
//        int artistId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        System.out.print("Introduceti Titlul: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Introduceti Data Lansarii (yyyy-MM-dd): ");
//        String releaseDateStr = scanner.nextLine();
//        LocalDate releaseDate = LocalDate.parse(releaseDateStr);
//
//        Album updatedAlbum = new Album(albumId, artistId, title, releaseDate);
//        albumRepo.updateAlbume(updatedAlbum);
//        System.out.println("Album actualizat cu succes.");
//    }
//
//    private static void deleteAlbum() {
//        System.out.print("Introduceti ID-ul Albumului pentru al sterge: ");
//        int albumId = scanner.nextInt();
//        scanner.nextLine();  // Consume newline character
//
//        albumRepo.removeAlbum(albumId);
//        System.out.println("Album sters cu succes.");
//    }
}

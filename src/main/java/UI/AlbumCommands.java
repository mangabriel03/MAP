package UI;

import RepoDB.AlbumRepoDB;
import domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
@ShellComponent
public class AlbumCommands {
    @Autowired
    private AlbumRepoDB albumRepo;
    private final Scanner scanner = new Scanner(System.in);

    @ShellMethod("Create a new album")
    public String createAlbum(
            @ShellOption(help = "ID of the artist") int artistId,
            @ShellOption(help = "Title of the album") String title,
            @ShellOption(help = "Release date in the format yyyy-MM-dd") String releaseDateStr) {

        LocalDate releaseDate = LocalDate.parse(releaseDateStr);

        // Perform the necessary logic with the provided inputs
        Album a = new Album(artistId,title,releaseDate);
        Album createdAlbum = albumRepo.save(a);
        // return "Album created with ID: " + createdAlbum.getIdAlbum();

        return "Album created successfully with ID: "+createdAlbum.getIdAlbum()+" .";
    }
    @ShellMethod("View all albums")
    public String viewAllAlbums() {
        List<Album> albums = albumRepo.findAll();
        StringBuilder result = new StringBuilder();

        for (Album album : albums) {
            result.append(album).append("\n");
        }

        return result.toString();
    }

    @ShellMethod("Update an album")
    public String updateAlbum(
            @ShellOption(help = "ID of the album to update") long albumId) {
        Optional<Album> existingAlbum = albumRepo.findById(albumId);

        if (existingAlbum == null) {
            return "Albumul nu a fost gasit.";
        }

        // Restul logicii de actualizare a albumului
        // De exemplu, puteți solicita noi informații de la utilizator sau faceți modificări directe.

        return "Albumul cu ID " + albumId + " a fost actualizat.";
    }
    @ShellMethod("Delete an album")
    public String deleteAlbum(@ShellOption(help = "ID of the album to delete") long albumId) {
        // Perform logic to remove the album
        albumRepo.deleteById(albumId);

        //if (deleted) {
        return "Album with ID " + albumId + " deleted successfully.";
        // } else {
        //    return "Album with ID " + albumId + " not found.";
        // }
    }



}

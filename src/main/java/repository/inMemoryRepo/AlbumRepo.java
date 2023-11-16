package repository.inMemoryRepo;

import domain.Album;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepo {
    private final List<Album> albume = new ArrayList<>();
    private int nextIdAlbum = 1;
    public Album createAlbum(int idTrupa, String titlu, LocalDate anLansare){
        Album album = new Album(nextIdAlbum,idTrupa ,titlu, anLansare);
        albume.add(album);
        nextIdAlbum++;
        return album;
    }

    public Album getAlbumById(int id){
        for (Album album : albume){
            if (album.getIdAlbum() == id)
                return album;
        }
        return null;
    }

    public List<Album> getAllAlbume(){
        return this.albume;
    }

    public Album updateAlbume(Album album){
        for (Album a : albume){
            if (a.getIdAlbum() == album.getIdAlbum()){
                a.setIdAlbum(album.getIdAlbum());
                a.setIdTrupa(album.getIdTrupa());
                a.setTitlu(album.getTitlu());
                a.setAnLansare(album.getAnLansare());
            }
        }
        return album;
    }

    public void removeAlbum(int id){
        Album albumToRemove = getAlbumById(id);
        if (albumToRemove != null)
            albume.remove(albumToRemove);
    }
}

package RepoDB;

import domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Transactional
@Repository
public interface AlbumRepoDB extends JpaRepository<Album, Long>{

}

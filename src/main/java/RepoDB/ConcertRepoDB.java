package RepoDB;

import domain.Concert;
import domain.Trupa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConcertRepoDB extends JpaRepository<Concert, Long>{
}


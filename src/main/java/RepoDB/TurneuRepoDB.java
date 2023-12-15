package RepoDB;

import domain.Turneu;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TurneuRepoDB extends JpaRepository<Turneu, Long>{
}

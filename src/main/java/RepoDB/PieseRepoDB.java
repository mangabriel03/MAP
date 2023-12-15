package RepoDB;

import domain.Piesa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PieseRepoDB extends JpaRepository<Piesa, Long>{
}

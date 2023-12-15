package RepoDB;

import domain.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MerchandiseRepoDB extends JpaRepository<Merchandise, Long>{
}

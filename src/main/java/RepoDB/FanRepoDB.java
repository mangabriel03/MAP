package RepoDB;

import domain.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FanRepoDB extends JpaRepository<Fan, Long>{
}


package RepoDB;

import domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManagerRepoDB extends JpaRepository<Manager, Long>{
}

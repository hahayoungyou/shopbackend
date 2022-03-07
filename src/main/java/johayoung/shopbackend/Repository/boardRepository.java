package johayoung.shopbackend.Repository;

import johayoung.shopbackend.entity.board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface boardRepository extends JpaRepository<board,Integer> {


}



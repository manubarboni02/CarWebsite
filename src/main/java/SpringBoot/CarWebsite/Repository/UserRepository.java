package SpringBoot.CarWebsite.Repository;

import SpringBoot.CarWebsite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Override
    <S extends User> List<S> saveAllAndFlush(Iterable<S> entities);
}



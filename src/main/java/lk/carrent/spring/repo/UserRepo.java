package lk.carrent.spring.repo;

import lk.carrent.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,String> {
    @Query(value = "select * from user WHERE username=:username AND password=:pass",nativeQuery = true)
    User searchByUserNameAndPassword(@Param("username") String username, @Param("pass") String pass);
}

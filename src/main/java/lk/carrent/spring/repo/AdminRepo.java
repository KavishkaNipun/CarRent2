package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Admin;
import lk.carrent.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepo extends JpaRepository<Admin,String> {
    @Query(value = "select * from admin WHERE firstName LIKE %:cName% OR lastName LIKE %:cName%",nativeQuery = true)
    List<Admin> searchAdminsByName(@Param("cName") String name);

    boolean existsAdminByNic(String nic);
}

package lk.carrent.spring.repo;

import lk.carrent.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
    @Query(value = "select * from vehicle WHERE vehicleID LIKE %:vID% OR transmissionType LIKE %:tType%",nativeQuery = true)
    List<Vehicle> searchVehicleByBrand(@Param("tType") String name);

    boolean existsVehicleByVehicleID(String vehicleID);
}

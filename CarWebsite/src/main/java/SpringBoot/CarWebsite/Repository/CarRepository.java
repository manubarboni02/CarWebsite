package SpringBoot.CarWebsite.Repository;

import SpringBoot.CarWebsite.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();

    @Override
    <S extends Car> S saveAndFlush(S entity);
    @Query(value = "select c from Car c where c.carManufacturer like coalesce(?1, c.carManufacturer)"+
            "  AND  c.carColor like coalesce(?2, c.carColor)" +
            "  AND c.fuelType like coalesce(?3, c.fuelType)")
    List<Car> findAllByKeywords(String filter1, String filter2, String filter3);

    void delete(Car car);

    @Override
    void flush();

    Optional<Car> findCarByRegistrationNumber(String registrationNumber);
}

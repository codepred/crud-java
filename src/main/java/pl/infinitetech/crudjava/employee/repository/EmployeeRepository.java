package pl.infinitetech.crudjava.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.infinitetech.crudjava.employee.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    @Query(value = "SELECT * FROM employee u WHERE u.email = :email and u.password = :password",
            nativeQuery = true)
    EmployeeEntity findByEmailAndPassword(
            @Param("email") String  email, @Param("password") String password);

}

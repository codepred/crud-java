package pl.infinitetech.crudjava.complaint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.infinitetech.crudjava.complaint.model.ComplaintEntity;
import pl.infinitetech.crudjava.employee.model.EmployeeEntity;

@Repository
public interface ComplaintRepository extends CrudRepository<ComplaintEntity, Long> {
}

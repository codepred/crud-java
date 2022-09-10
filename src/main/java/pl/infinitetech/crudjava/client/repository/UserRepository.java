package pl.infinitetech.crudjava.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.infinitetech.crudjava.client.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}

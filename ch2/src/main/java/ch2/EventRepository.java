package ch2;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<event, Integer> {

}

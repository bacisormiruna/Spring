package org.example.hello_spring.data;

import org.example.hello_spring.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {


}


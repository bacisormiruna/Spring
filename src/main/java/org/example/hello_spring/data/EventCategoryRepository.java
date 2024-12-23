package org.example.hello_spring.data;

import org.example.hello_spring.models.Event;
import org.example.hello_spring.models.EventCategory;
import org.springframework.data.repository.CrudRepository;

public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {
}

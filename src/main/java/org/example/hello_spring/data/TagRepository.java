package org.example.hello_spring.data;

import org.example.hello_spring.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}

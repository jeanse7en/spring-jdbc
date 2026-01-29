package com.moellj.jdbc.showcase.setinlist;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Table("queue")
public record RestaurantQueue(
    @Id String id,
    @Version int version,
    @MappedCollection(idColumn = "queue_id", keyColumn = "position")
    List<Person> persons
){}

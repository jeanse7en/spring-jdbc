package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Table("queue")
public class RestaurantQueue2{
    @Id
    private String id;
    @Version
    private int version;
    @MappedCollection(idColumn = "queue_id", keyColumn = "position")
    private Set<Person2> persons;

    public RestaurantQueue2() {
    }

    public RestaurantQueue2(String id, List<Person2> persons) {
        this.id = id;
        this.persons = persons.stream().peek(e -> e.setQueueId(id)).collect(Collectors.toSet());
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public Set<Person2> getPersons() {
        return persons;
    }
}

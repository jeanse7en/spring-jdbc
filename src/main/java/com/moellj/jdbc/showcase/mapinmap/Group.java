package com.moellj.jdbc.showcase.mapinmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("group")
public class Group {

    private String group;
    private String description;

    @MappedCollection(idColumn = "class", keyColumn = "person")
    private Map<String, Person> persons;

    @MappedCollection(idColumn = "class", keyColumn = "group")
    private Map<String, GroupMetadata> metadata;


    public Group(String name, List<Person> persons, GroupMetadata metadata) {
        this.group = name;
        this.persons = persons.stream().collect(Collectors.toMap(Person::getPerson, Function.identity()));
        this.metadata = Map.of(this.group, metadata);
    }
}

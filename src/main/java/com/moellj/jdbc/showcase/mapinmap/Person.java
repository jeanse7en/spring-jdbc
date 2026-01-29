package com.moellj.jdbc.showcase.mapinmap;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Table("person")
@NoArgsConstructor
public class Person {

    private String person;
    private String description;

    @MappedCollection(idColumn = "class", keyColumn = "skill")
    private Map<String, Skill> skills;

    public Person(String name, String description, List<Skill> skills) {
        this.person = name;
        this.description = description;
        this.skills = skills.stream().collect(Collectors.toMap(Skill::getSkill, skill -> skill));
    }
}

package com.moellj.jdbc.showcase.mapinmap;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@Table("class")
public class Class implements Persistable<String> {
    @Id
    private String id;

    @MappedCollection(idColumn = "class", keyColumn = "group")
    private Map<String, Group> groups;

    public Class(String id, List<Group> groups) {
        this.id = id;
        this.groups = groups.stream().collect(Collectors.toMap(Group::getGroup, Function.identity()));
    }

    @Override
    public boolean isNew() {
        return true;
    }
}

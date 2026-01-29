package com.moellj.jdbc.showcase.setinlist;

import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;


@Table("person")
public record Person(
        String id,
        Integer position,
        // Set of skills doesn't work. This also isn't fixed by adding `keyColumn = "skill_idx"` or  `keyColumn = "position_in_queue"`
        // Unrelated: Thought the idColumn should be the person_id but seems to actually be the queue_id
        @MappedCollection(idColumn = "queue_id", keyColumn = "name") List<Skill> skills) {
}

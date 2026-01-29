package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Table("person")
public class Person2 extends QueueAggregateId {
    @Id
    private String position;

    @MappedCollection(idColumn = "position", keyColumn = "name")
    private Set<Skill2> skills;

    @MappedCollection(idColumn = "position")
    private PersonMetadata2 metadata;

    public Person2() {
    }

    public Person2(String queueId, String position, List<Skill2> skills, PersonMetadata2 metadata) {
        this.position = position;
        this.queueId = queueId;
        this.skills = skills.stream().peek(e -> e.setQueueId(this.getQueueId())).collect(Collectors.toSet());
        this.metadata = metadata;
        this.metadata.setQueueId(this.getQueueId());
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PersonMetadata2 getMetadata() {
        return metadata;
    }
}

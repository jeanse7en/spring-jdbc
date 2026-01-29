package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Table("person_metadata")
public class PersonMetadata2 extends QueueAggregateId{
    private String position;
    private String firstName;
    private String lastName;

    @MappedCollection(idColumn = "position")
    private PersonMetadataContext2 context;

    @MappedCollection(idColumn = "position", keyColumn = "tag")
    private Set<PersonMetadataTag2> tags;

    public PersonMetadata2() {
    }

    public PersonMetadata2(
        String position,
        String firstName,
        String lastName,
        PersonMetadataContext2 context,
        List<PersonMetadataTag2> tags) {
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.context = context;
        this.context.setQueueId("queue");
        this.tags = tags.stream().peek(e -> e.setQueueId("queue")).collect(Collectors.toSet());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getPosition() {
//        return position;
//    }

    public Set<PersonMetadataTag2> getTags() {
        return tags;
    }
}

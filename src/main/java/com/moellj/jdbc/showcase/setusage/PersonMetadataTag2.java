package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
import java.util.stream.Collectors;

@Table("person_metadata_tag")
public class PersonMetadataTag2 {
    @Id
    private String tag;
    @Column("queue_id")
    protected String queueId;

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getQueueId() {
        return queueId;
    }
    private String position;

    @MappedCollection(idColumn = "tag", keyColumn = "locale")
    private Set<PersonMetadataTagContent2> tagContents;

    public PersonMetadataTag2() {
    }
    public PersonMetadataTag2(String position, String tag) {
        this.tag = tag;
        this.position = position;
    }

    public PersonMetadataTag2(String tag, String position, Set<PersonMetadataTagContent2> tagContents) {
        this.tag = tag;
        this.position = position;
        this.tagContents = tagContents.stream().map(e -> {
            e.setQueueId("queue");
            e.setPosition(position);
            return e;
        }).collect(Collectors.toSet());
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

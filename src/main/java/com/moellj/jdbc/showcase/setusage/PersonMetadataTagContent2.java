package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("person_metadata_tag_content")
public class PersonMetadataTagContent2 {
    private String position;
//    private String tag;
    private String locale;
    private String description;

    @Column("queue_id")
    protected String queueId;

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getQueueId() {
        return queueId;
    }

    public PersonMetadataTagContent2() {
    }

    public PersonMetadataTagContent2(String position, String tag, String locale, String description) {
//        this.tag = tag;
        this.position = position;
        this.locale = locale;
        this.description = description;
    }

//    public String getTag() {
//        return tag;
//    }
//
//    public void setTag(String tag) {
//        this.tag = tag;
//    }

    public void setPosition(String position) {
        this.position = position;
    }
}

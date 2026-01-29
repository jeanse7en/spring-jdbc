package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("person_metadata_context")
public class PersonMetadataContext2{
    @Column("queue_id")
    protected String queueId;
    private String position;
    private String source;
    private String contextKey;
    private String contextValue;


    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getQueueId() {
        return queueId;
    }

    public PersonMetadataContext2(String position, String source) {
        this.position = position;
        this.source = source;
    }

    public void setSource(String source) {
        this.source = source;
    }

//    public String getPosition() {
//        return position;
//    }

    public String getSource() {
        return source;
    }

    public String getContextKey() {
        return contextKey;
    }

    public String getContextValue() {
        return contextValue;
    }
}

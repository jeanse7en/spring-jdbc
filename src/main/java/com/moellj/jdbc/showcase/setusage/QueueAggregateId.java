package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.relational.core.mapping.Column;

public abstract class QueueAggregateId {
    @Column("queue_id")
    protected String queueId;

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getQueueId() {
        return queueId;
    }
}

package com.moellj.jdbc.showcase.setusage;

import org.springframework.data.relational.core.mapping.Table;

@Table("skill")
public class Skill2 extends QueueAggregateId {
    private String position;
    private String name;
    private String level;

    public Skill2() {
    }

    public Skill2(String position, String name, String level) {
        this.position = position;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}

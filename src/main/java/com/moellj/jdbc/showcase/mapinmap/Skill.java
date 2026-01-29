package com.moellj.jdbc.showcase.mapinmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("skill")
public class Skill {
    private String skill;
    private String description;
}

package com.moellj.jdbc.showcase.mapinmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("group_metadata_tag")
public class GroupMetadataTag {
    private String tag;
    private String description;
}

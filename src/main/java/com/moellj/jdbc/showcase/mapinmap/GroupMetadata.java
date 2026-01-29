package com.moellj.jdbc.showcase.mapinmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@Table("group_metadata")
public class GroupMetadata {
    private String alias;

    @MappedCollection(idColumn = "class", keyColumn = "tag")
    private Map<String, GroupMetadataTag> metadatas;


    public GroupMetadata(String alias, List<GroupMetadataTag> tags) {
        this.alias = alias;
        this.metadatas = tags.stream().collect(Collectors.toMap(GroupMetadataTag::getTag, Function.identity()));
    }
}

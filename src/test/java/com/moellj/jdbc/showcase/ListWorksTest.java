package com.moellj.jdbc.showcase;

import com.moellj.jdbc.showcase.mapinmap.ClassRepository;
import com.moellj.jdbc.showcase.mapinmap.Group;
import com.moellj.jdbc.showcase.mapinmap.GroupMetadata;
import com.moellj.jdbc.showcase.mapinmap.GroupMetadataTag;
import com.moellj.jdbc.showcase.mapinmap.Person;
import com.moellj.jdbc.showcase.mapinmap.Class;
import com.moellj.jdbc.showcase.mapinmap.Skill;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@Import({TestContainersConfig.class})
class ListWorksTest {

    @Autowired
    ClassRepository classRepository;

    @Test
    void saveAndLoad() {
        String group1 = "group1";
        final var group1Entity = new Group(group1,
            List.of(
                new Person("person1", "person1_description", List.of()),
                new Person("person2", "person2_description", List.of(
                    new Skill("person1_skill1", "person1_skill1"),
                    new Skill("person1_skill2", "person1_skill1")))),
            new GroupMetadata("group1_metadata",
                List.of(new GroupMetadataTag("Tag1", "Tag1 description"),
                    new GroupMetadataTag("Tag2", "Tag2 description")))
        );

        final var queue = new Class("class", List.of(group1Entity));
        final var savedQueue = classRepository.save(queue);
        final var loadedQueue = classRepository.findById(queue.getId());

        assertTrue(loadedQueue.isPresent());
        Assertions.assertThat(loadedQueue.get())
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .ignoringCollectionOrder()
            .isEqualTo(queue);
    }
}

package com.moellj.jdbc.showcase;

import com.moellj.jdbc.showcase.setusage.Person2;
import com.moellj.jdbc.showcase.setusage.PersonMetadata2;
import com.moellj.jdbc.showcase.setusage.PersonMetadataContext2;
import com.moellj.jdbc.showcase.setusage.PersonMetadataTag2;
import com.moellj.jdbc.showcase.setusage.PersonMetadataTagContent2;
import com.moellj.jdbc.showcase.setusage.QueueRepository3;
import com.moellj.jdbc.showcase.setusage.RestaurantQueue2;
import com.moellj.jdbc.showcase.setusage.Skill2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@Import({TestContainersConfig.class})
class SetCollectionTest {

    @Autowired
    QueueRepository3 queueRepository;

    @Test
    void workaround_saveAndLoad() {
        String positionPi1 = "p1";
        String queueId = "queue";
        final var person = new Person2(queueId, positionPi1,
            List.of(
                new Skill2(positionPi1,"coding", "level-1"),
                new Skill2(positionPi1,"testing", "level-2")),
            new PersonMetadata2(positionPi1,"PersonFirstName", "PersonLastName",
                new PersonMetadataContext2(positionPi1, "AdminSource"),
                List.of(new PersonMetadataTag2(positionPi1,"Tag1"),
                    new PersonMetadataTag2(positionPi1,"Tag2",
                        Set.of(new PersonMetadataTagContent2(positionPi1, "Tag2", "en", "Tag2 description")))))
        );
        String position2 = "p2";
        final var person2 = new Person2(queueId, position2,
            List.of(
                new Skill2(position2, "coding2", "level-12"),
                new Skill2(position2, "testing2", "level-22")),
            new PersonMetadata2(position2, "PersonFirstName2", "PersonLastName2",
                new PersonMetadataContext2(position2, "AdminSource2"),
                List.of(new PersonMetadataTag2(position2,"Tag1"), new PersonMetadataTag2(position2,"Tag2"))));

        String position3 = "p3";
        final var person3 = new Person2(queueId, position3,
            List.of(
                new Skill2(position3, "coding2", "level-12"),
                new Skill2(position3, "testing2", "level-22")),
            new PersonMetadata2(position3, "PersonFirstName2", "PersonLastName2",
                new PersonMetadataContext2(position3, "AdminSource2"),
                List.of(new PersonMetadataTag2(position2,"Tag1"), new PersonMetadataTag2(position2,"Tag2"))));

        final var queue = new RestaurantQueue2(queueId, List.of(person, person2, person3));
        final var savedQueue = queueRepository.save(queue);
        final var loadedQueue = queueRepository.findById(queue.getId());

        assertTrue(loadedQueue.isPresent());

        assertThat(loadedQueue.get())
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .ignoringCollectionOrder()
            .isEqualTo(queue);
        System.out.println(loadedQueue.get());
    }
}

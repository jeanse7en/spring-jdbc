package com.moellj.jdbc.showcase.setinlist;

import org.springframework.data.repository.CrudRepository;


public interface QueueRepository
        extends CrudRepository<RestaurantQueue, String> {
}

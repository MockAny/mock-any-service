package com.mockany.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mockany.entity.Mock;

public interface MockRepository extends MongoRepository<Mock, String> {

}

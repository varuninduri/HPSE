package com.distance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.distance.model.Distance;

@Repository
public interface DistanceRepository extends MongoRepository<Distance, String> {

}

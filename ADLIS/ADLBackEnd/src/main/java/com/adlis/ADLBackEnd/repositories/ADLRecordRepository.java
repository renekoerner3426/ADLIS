package com.adlis.ADLBackEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adlis.ADLBackEnd.entities.ADLRecord;


@Repository
public interface ADLRecordRepository extends MongoRepository<ADLRecord, Long> {
}
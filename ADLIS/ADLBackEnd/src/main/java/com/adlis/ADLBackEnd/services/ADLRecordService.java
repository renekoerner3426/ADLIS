package com.adlis.ADLBackEnd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adlis.ADLBackEnd.entities.ADLRecord;
import com.adlis.ADLBackEnd.repositories.ADLRecordRepository;


@Service
public class ADLRecordService {

	@Autowired
	private ADLRecordRepository adlRecordRepository;

	public ADLRecord saveRecord(ADLRecord adlRecord) {
		return this.adlRecordRepository.save(adlRecord);
	}
	
	public List<ADLRecord> getRecordList() {
		Iterable<ADLRecord> savedEntitys = this.adlRecordRepository.findAll();
		List<ADLRecord> recordList = new ArrayList<>();
		savedEntitys.forEach(savedEntity -> recordList.add(savedEntity));
		return recordList;
	}
}		
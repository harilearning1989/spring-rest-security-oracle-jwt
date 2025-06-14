package com.web.demo.repos;

import com.web.demo.models.HrRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrRecordRepository extends JpaRepository<HrRecords, Long> {

    // Returns the first 10 records
    List<HrRecords> findTop10By();
}

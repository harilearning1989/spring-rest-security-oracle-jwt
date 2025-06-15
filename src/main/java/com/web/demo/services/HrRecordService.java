package com.web.demo.services;

import com.web.demo.dtos.HrRecordDto;

import java.util.List;

public interface HrRecordService {
    List<HrRecordDto> getAllHrRecord();

    List<HrRecordDto> findTop10By();
}

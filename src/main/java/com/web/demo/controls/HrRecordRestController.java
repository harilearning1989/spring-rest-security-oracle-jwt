package com.web.demo.controls;

import com.web.demo.dtos.HrRecordDto;
import com.web.demo.services.HrRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hr")
public class HrRecordRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final HrRecordService hrRecordService;

    public HrRecordRestController(HrRecordService hrRecordService) {
        this.hrRecordService = hrRecordService;
    }

    @GetMapping("all")
    public ResponseEntity<List<HrRecordDto>> getAllHrRecord() {
        List<HrRecordDto> hrRecordDtoList = hrRecordService.getAllHrRecord();
        if (hrRecordDtoList.isEmpty()) {
            LOGGER.warn("No HR records found");
            return ResponseEntity.noContent().build();
        }
        LOGGER.info("Returning {} HR records", hrRecordDtoList.size());
        return ResponseEntity.ok(hrRecordDtoList);
    }
}

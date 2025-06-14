package com.web.demo.services;

import com.web.demo.dtos.HrRecordDto;
import com.web.demo.models.HrRecords;
import com.web.demo.repos.HrRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HrRecordServiceImpl implements HrRecordService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final HrRecordRepository hrRecordRepository;

    public HrRecordServiceImpl(HrRecordRepository hrRecordRepository) {
        this.hrRecordRepository = hrRecordRepository;
    }

    @Override
    public List<HrRecordDto> getAllHrRecord() {
        LOGGER.info("getAllHrRecord");
        List<HrRecords>  hrRecordsList = hrRecordRepository.findTop10By();
        if (hrRecordsList.isEmpty()) {
            LOGGER.warn("No HR records found in the database");
            return List.of();
        }
        return Optional.of(hrRecordsList)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(HrRecordServiceImpl::toDto).toList();
    }

    public static HrRecordDto toDto(HrRecords entity) {
        return new HrRecordDto(
                entity.getId(),
                entity.getEmpId(),
                entity.getNamePrefix(),
                entity.getFirstName(),
                entity.getMiddleInitial(),
                entity.getLastName(),
                entity.getGender(),
                entity.getEmail(),
                entity.getFatherName(),
                entity.getMotherName(),
                entity.getMotherMaidenName(),
                entity.getDateOfBirth(),
                entity.getTimeOfBirth(),
                entity.getAgeInYrs(),
                entity.getWeightInKgs(),
                entity.getDateOfJoining(),
                entity.getQuarterOfJoining(),
                entity.getHalfOfJoining(),
                entity.getYearOfJoining(),
                entity.getMonthOfJoining(),
                entity.getMonthNameOfJoining(),
                entity.getShortMonth(),
                entity.getDayOfJoining(),
                entity.getDowOfJoining(),
                entity.getShortDow(),
                entity.getAgeInCompanyYears(),
                entity.getSalary(),
                entity.getLastHike(),
                entity.getSsn(),
                entity.getPhoneNo(),
                entity.getPlaceName(),
                entity.getCounty(),
                entity.getCity(),
                entity.getState(),
                entity.getZip(),
                entity.getRegion(),
                entity.getUserName(),
                entity.getPassword()
        );
    }

}

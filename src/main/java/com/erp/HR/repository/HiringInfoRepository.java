package com.erp.HR.repository;

import com.erp.HR.domain.HiringInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HiringInfoRepository extends CrudRepository<HiringInfo, Integer> {

    List<HiringInfo> getAllByTrainingDateAndDocumentsSubmittedAndJoiningDate(Date trainingDate, char documentsSubmitted, Date joiningDate);
    HiringInfo getByHiringId(int hiringId);

}
package com.erp.HR.service;

import com.erp.HR.domain.HiringInfo;
import com.erp.HR.repository.HiringInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class HiringService {

    @Autowired
    HiringInfoRepository hiringInfoRepository;

    public List<HiringInfo> getJoineeDetails(Date trainingDate, char documentsSubmitted, Date joiningDate){
        return hiringInfoRepository.getAllByTrainingDateAndDocumentsSubmittedAndJoiningDate(trainingDate, documentsSubmitted, joiningDate);
    }

    public boolean updateHireeDetails(int hiringId, Date trainingDate, char documentsSubmitted){

        try {
            HiringInfo hiringInfo = hiringInfoRepository.getByHiringId(hiringId);
            if (hiringInfo == null) {
                return false;
            } else {
                hiringInfo.setTrainingDate(trainingDate);
                hiringInfo.setDocumentsSubmitted(documentsSubmitted);
                hiringInfoRepository.save(hiringInfo);
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean addNewJoinee(int employeeId, char employmentType){

        try {
            HiringInfo hiringInfo = new HiringInfo();
            hiringInfo.setEmployeeId(employeeId);
            hiringInfo.setEmploymentType(employmentType);
            hiringInfoRepository.save(hiringInfo);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

}

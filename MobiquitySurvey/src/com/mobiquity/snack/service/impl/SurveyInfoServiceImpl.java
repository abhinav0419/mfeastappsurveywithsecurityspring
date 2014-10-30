package com.mobiquity.snack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.SurveyInfoEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.repository.SurveyInfoRepository;
import com.mobiquity.snack.repository.SurveyRepository;
import com.mobiquity.snack.repository.UserRepository;
import com.mobiquity.snack.service.SurveyInfoService;

@Service
public class SurveyInfoServiceImpl implements SurveyInfoService {

	@Autowired
	private SurveyInfoRepository surveyInfoRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SurveyRepository surveyRepository;

	@Transactional
	public SurveyInfoEntity getCurrentSurveyInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void saveSurveyInfo(SurveyInfoEntity surveyInfoEntity,long userId,long surveyId) {
		//long id = surveyInfoEntity.getSurveyInfoId();
		UserEntity userEntity = userRepository.getUserByUserId(userId);
		
		SurveyEntity surveyEntity = surveyRepository.getSurveyById(surveyId);
		surveyInfoEntity.setSurveyId(surveyEntity);
		surveyInfoEntity.setUserId(userEntity);
		//surveyInfoEntity.setSurveyInfoId(id);
		surveyInfoRepository.save(surveyInfoEntity);
		
		
	}

    @Transactional
    public SurveyInfoEntity getSurveyInfoByUser(UserEntity userId) {
       SurveyInfoEntity  surveyInfoEntity = surveyInfoRepository.getSurveyInfoByUser(userId);
        return surveyInfoEntity;
    }

    @Transactional
    public SurveyInfoEntity getSurveyInfoById(long id) {
        SurveyInfoEntity entity = surveyInfoRepository.findOne(id);
        return entity;
    }
    
    @Transactional
    public List<SurveyInfoEntity> fecthSurverySelection(long surveyId) {
        // TODO Auto-generated method stub
        List<SurveyInfoEntity> surveySelectionList = surveyInfoRepository.fetchSurverySelection(surveyId);
        return surveySelectionList;
    }

    @Transactional
    public List<SurveyInfoEntity> fetchSurveySelection(long surveyId, String optionName) {
        // TODO Auto-generated method stub
        List<SurveyInfoEntity> surveySelectionList = surveyInfoRepository.fetchSurverySelection(surveyId,optionName);
        return surveySelectionList;
    }

   @Transactional
    public SurveyInfoEntity getSurveyInfoBySurvey(SurveyEntity surveyId) {
       SurveyInfoEntity surveyInfoEntity = surveyInfoRepository.getSurveyInfoBySurvey(surveyId);
        return surveyInfoEntity;
    }

   @Transactional
public SurveyInfoEntity getInfoByUserAndSurvey(UserEntity userId, SurveyEntity surveyId) {
    SurveyInfoEntity surveyInfoEntity = surveyInfoRepository.getInfoByUserAndSurvey(userId, surveyId);
    return surveyInfoEntity;
}



	
	
	
}

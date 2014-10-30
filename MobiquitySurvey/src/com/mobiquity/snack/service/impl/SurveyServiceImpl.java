package com.mobiquity.snack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.repository.SurveyRepository;
import com.mobiquity.snack.repository.UserRepository;
import com.mobiquity.snack.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private UserRepository UserRepository;
	
	@Transactional
	public void saveSurvey(SurveyEntity surveyEntity) {
		surveyRepository.save(surveyEntity);
		
	}
	
	@Transactional
	public SurveyEntity addUserToSurvey(Long userId, SurveyEntity surveyEntity){
	    Long long1 = surveyEntity.getSurveyId();
		UserEntity userEntity = UserRepository.getUserByUserId(userId);
		surveyEntity.setCreatedUserId(userEntity);
		surveyEntity.setSurveyId(long1);
		surveyRepository.save(surveyEntity);
		return surveyEntity;
	}

	@Transactional
	public void closeCurrentSurvey(UserEntity userEntity,SurveyEntity surveyEntity) {
		long surId = surveyEntity.getSurveyId();
		System.out.println("current sur id is " + surId);
		UserEntity entity =UserRepository.getUserByUserId(userEntity.getUserId());
		System.out.println("updating query");
		surveyEntity.setOpenSurveyFlag(false);
		surveyEntity.setCreatedUserId(entity);
		surveyEntity.setSurveyId(surId);
		surveyRepository.save(surveyEntity);
	}
	
	@Transactional
	public void changeSurveyStatus(long id) {
		SurveyEntity surveyEntity = surveyRepository.findOne(id);
		boolean flag = surveyEntity.isOpenSurveyFlag();
		if(flag){
			surveyEntity.setOpenSurveyFlag(false);
		}else{
			surveyEntity.setOpenSurveyFlag(true);
		}
		surveyEntity.setSurveyId(id);
		surveyRepository.save(surveyEntity);
		System.out.println("st changed");
	}
	@Transactional
	public List<SurveyEntity> getCurrentSurvey() {
		List<SurveyEntity> entityList =surveyRepository.getCurrentSurvey();
		return entityList ;
	}

    @Override
    public SurveyEntity getSurveyById(long surveyId) {
        SurveyEntity surveyEntity = surveyRepository.getSurveyById(surveyId);
        return surveyEntity;
    }
	
	

}

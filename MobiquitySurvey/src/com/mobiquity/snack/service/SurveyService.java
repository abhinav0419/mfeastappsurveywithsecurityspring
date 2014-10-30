package com.mobiquity.snack.service;

import java.util.List;

import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.UserEntity;

public interface SurveyService {
	void saveSurvey(SurveyEntity surveyEntity);
	
	SurveyEntity addUserToSurvey(Long userId, SurveyEntity surveyEntity);
	
	void closeCurrentSurvey(UserEntity userEntity,SurveyEntity surveyEntity);
	List<SurveyEntity> getCurrentSurvey();
	 void changeSurveyStatus(long id);
	 SurveyEntity getSurveyById(long surveyId);
}

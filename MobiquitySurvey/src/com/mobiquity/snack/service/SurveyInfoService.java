package com.mobiquity.snack.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.SurveyInfoEntity;
import com.mobiquity.snack.model.UserEntity;

public interface SurveyInfoService {
	
	SurveyInfoEntity getCurrentSurveyInfo();
	
	void saveSurveyInfo(SurveyInfoEntity surveyInfoEntity,long userId,long surveyId);
	
	SurveyInfoEntity getSurveyInfoByUser( UserEntity userId);
	SurveyInfoEntity getSurveyInfoById( long id);
List<SurveyInfoEntity> fecthSurverySelection(long surveyId);
    
    List<SurveyInfoEntity> fetchSurveySelection(long surveyId, String optionName);
    SurveyInfoEntity getSurveyInfoBySurvey( SurveyEntity surveyId);
    SurveyInfoEntity getInfoByUserAndSurvey(UserEntity userId,SurveyEntity surveyId);
	
}

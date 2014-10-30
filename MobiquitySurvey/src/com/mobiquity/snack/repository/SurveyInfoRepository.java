package com.mobiquity.snack.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.SurveyInfoEntity;
import com.mobiquity.snack.model.UserEntity;

@MappedSuperclass
public interface SurveyInfoRepository extends SurveyJpaRepository<SurveyInfoEntity, Long>{

    @Query("SELECT si FROM SurveyInfoEntity si WHERE si.userId = :userId")
    SurveyInfoEntity getSurveyInfoByUser(@Param("userId") UserEntity userId);
    
    @Query("SELECT si FROM SurveyInfoEntity si WHERE si.surveyId = :surveyId")
    SurveyInfoEntity getSurveyInfoBySurvey(@Param("surveyId") SurveyEntity surveyId);
    
    @Query("SELECT si FROM SurveyInfoEntity si WHERE si.userId = :userId AND si.surveyId = :surveyId ")
    SurveyInfoEntity getInfoByUserAndSurvey(@Param("userId") UserEntity userId,@Param("surveyId") SurveyEntity surveyId);
    
    
    @Query("SELECT sinfo FROM SurveyInfoEntity sinfo LEFT JOIN sinfo.surveyId survery "
            + " LEFT JOIN sinfo.userId user WHERE survery.surveyId = :paramSurveyId ORDER BY sinfo.surveyOption , user.firstName")
    List<SurveyInfoEntity> fetchSurverySelection(@Param("paramSurveyId") long surveyId);
    
    @Query("Select sinfo from SurveyInfoEntity sinfo Left Join sinfo.surveyId survery "
            + " left join sinfo.userId user where survery.surveyId = :paramSurveyId and sinfo.surveyOption <> :paramOptionName "
            + " order by sinfo.surveyOption, user.firstName")
    List<SurveyInfoEntity> fetchSurverySelection(@Param("paramSurveyId") long surveyId,@Param("paramOptionName") String optionName);
}

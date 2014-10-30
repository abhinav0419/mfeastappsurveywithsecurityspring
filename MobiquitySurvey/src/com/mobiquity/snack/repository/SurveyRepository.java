package com.mobiquity.snack.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.SurveyEntity;

@MappedSuperclass
public interface SurveyRepository extends SurveyJpaRepository<SurveyEntity, Long> {

@Query("SELECT se FROM SurveyEntity se")	
List<SurveyEntity> getCurrentSurvey();

@Query("SELECT se FROM SurveyEntity se WHERE se.surveyId = :surveyId")
SurveyEntity getSurveyById(@Param("surveyId") long surveyId);
}

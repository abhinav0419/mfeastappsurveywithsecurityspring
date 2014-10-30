package com.mobiquity.snack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SURVEY_INFO")
public class SurveyInfoEntity {
    
    @Id @GeneratedValue @Column(name = "SURVEY_INFO_ID") private long surveyInfoId;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "SURVEY_ID") private SurveyEntity surveyId;

    @OneToOne(cascade = CascadeType.ALL) private UserEntity userId;

    @Column(name = "SURVEY_OPTION") private String surveyOption;

    @Column(name = "FEEDBACK") private String feedback;

    @Column(name = "CREATED_DATE") private Date createdDate;

    public long getSurveyInfoId() {
        return surveyInfoId;
    }

    public void setSurveyInfoId(long surveyInfoId) {
        this.surveyInfoId = surveyInfoId;
    }

    public SurveyEntity getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(SurveyEntity surveyId) {
        this.surveyId = surveyId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getSurveyOption() {
        return surveyOption;
    }

    public void setSurveyOption(String surveyOption) {
        this.surveyOption = surveyOption;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}

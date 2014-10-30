package com.mobiquity.snack.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SURVEY")
public class SurveyEntity implements Serializable {

    private static final long serialVersionUID = 8485550040466408445L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "SURVEY_ID") private long surveyId;

    @Column(name = "SURVEY_NAME") private String surveyName;

    @Column(name = "SURVEY_DESCRIPTION") private String surveyDescription;
    @Enumerated(EnumType.STRING) @Column(name = "SURVEY_TYPE") private SurveyType surveyType;

    @Column(name = "VEG_OPTION") private String vegOption;

    @Column(name = "JAIN_OPTION") private String jainOption;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "USER_ID") private UserEntity createdUserId;

    @Temporal(TemporalType.DATE) @Column(name = "CREATED_DATE") private Date createdDate;

    @Column(name = "OPEN_SURVEY_FLAG") private boolean openSurveyFlag;

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public void setSurveyDescription(String description) {
        this.surveyDescription = description;
    }

    public SurveyType getType() {
        return surveyType;
    }

    public void setType(SurveyType type) {
        this.surveyType = type;
    }

    public String getVegOption() {
        return vegOption;
    }

    public void setVegOption(String vegOption) {
        this.vegOption = vegOption;
    }

    public String getJainOption() {
        return jainOption;
    }

    public void setJainOption(String jainOption) {
        this.jainOption = jainOption;
    }

    public UserEntity getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(UserEntity createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isOpenSurveyFlag() {
        return openSurveyFlag;
    }

    public void setOpenSurveyFlag(boolean openSurveyFlag) {
        this.openSurveyFlag = openSurveyFlag;
    }

}

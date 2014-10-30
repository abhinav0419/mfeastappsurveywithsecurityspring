package com.mobiquity.snack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name="USER_ROLE")
public class UserRoleEntity {
    @Id @GeneratedValue private long sequenceId;

    public long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(long sequenceId) {
        this.sequenceId = sequenceId;
    }

}

package com.mobiquity.snack.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mobiquity.snack.validation.EmailValidator;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue @Column(name = "USER_ID") private Long userId;

    @EmailValidator(message = "")
    @Column(name = "USER_EMAIL") private String userName;

    @Column(name = "PASSWORD") private String password;

    @NotNull @Size(min=3, max=25)
    @Column(name = "FIRST_NAME") private String firstName;
    
   @NotNull @Size(min=3, max=25)
    @Column(name = "MIDDLE_NAME") private String middleName;

   @NotNull @Size(min=3, max=25)
    @Column(name = "LAST_NAME") private String lastName;

    @Column(name = "SALT") private String salt;

    @Column(name = "ACTIVE") private boolean active;

    @Column(name = "DISPLAY_IMAGE") private Blob displayPic;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DOB") private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToOne(cascade = CascadeType.ALL) @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") }) private RoleEntity userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userEmail) {
        this.userName = userEmail;
    }

    public RoleEntity getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleEntity roleTable) {
        this.userRole = roleTable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Blob getDisplayPic() {
        return displayPic;
    }

    public void setDisplayPic(Blob displayPic) {
        this.displayPic = displayPic;
    }

}

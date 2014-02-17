/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anasabubacker
 */
@Entity
@Table(name = "user_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDb.findAll", query = "SELECT u FROM UserDb u"),
    @NamedQuery(name = "UserDb.findByUserSegNum", query = "SELECT u FROM UserDb u WHERE u.userSegNum = :userSegNum"),
    @NamedQuery(name = "UserDb.findByUserId", query = "SELECT u FROM UserDb u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDb.findByEmailAddress", query = "SELECT u FROM UserDb u WHERE u.emailAddress = :emailAddress"),
    @NamedQuery(name = "UserDb.findByPassword", query = "SELECT u FROM UserDb u WHERE u.password = :password"),
    @NamedQuery(name = "UserDb.findByAddress", query = "SELECT u FROM UserDb u WHERE u.address = :address"),
    @NamedQuery(name = "UserDb.findByPhoneNumber", query = "SELECT u FROM UserDb u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "UserDb.findByIsEmailVerified", query = "SELECT u FROM UserDb u WHERE u.isEmailVerified = :isEmailVerified"),
    @NamedQuery(name = "UserDb.findByIsPhoneVerified", query = "SELECT u FROM UserDb u WHERE u.isPhoneVerified = :isPhoneVerified"),
    @NamedQuery(name = "UserDb.findByName", query = "SELECT u FROM UserDb u WHERE u.name = :name")})
public class UserDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userSegNum")
    private Long userSegNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "userId")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isEmailVerified")
    private boolean isEmailVerified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPhoneVerified")
    private boolean isPhoneVerified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name")
    private String name;

    public UserDb() {
    }

    public UserDb(Long userSegNum) {
        this.userSegNum = userSegNum;
    }

    public UserDb(Long userSegNum, String userId, String emailAddress, String password, String address, String phoneNumber, boolean isEmailVerified, boolean isPhoneVerified, String name) {
        this.userSegNum = userSegNum;
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isEmailVerified = isEmailVerified;
        this.isPhoneVerified = isPhoneVerified;
        this.name = name;
    }

    public Long getUserSegNum() {
        return userSegNum;
    }

    public void setUserSegNum(Long userSegNum) {
        this.userSegNum = userSegNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public boolean getIsPhoneVerified() {
        return isPhoneVerified;
    }

    public void setIsPhoneVerified(boolean isPhoneVerified) {
        this.isPhoneVerified = isPhoneVerified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSegNum != null ? userSegNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDb)) {
            return false;
        }
        UserDb other = (UserDb) object;
        if ((this.userSegNum == null && other.userSegNum != null) || (this.userSegNum != null && !this.userSegNum.equals(other.userSegNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.UserDb[ userSegNum=" + userSegNum + " ]";
    }
    
}

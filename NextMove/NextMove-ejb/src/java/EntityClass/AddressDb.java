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
@Table(name = "address_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressDb.findAll", query = "SELECT a FROM AddressDb a"),
    @NamedQuery(name = "AddressDb.findByAddressSeqNum", query = "SELECT a FROM AddressDb a WHERE a.addressSeqNum = :addressSeqNum"),
    @NamedQuery(name = "AddressDb.findByAddressId", query = "SELECT a FROM AddressDb a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "AddressDb.findByUserId", query = "SELECT a FROM AddressDb a WHERE a.userId = :userId"),
    @NamedQuery(name = "AddressDb.findByAddress", query = "SELECT a FROM AddressDb a WHERE a.address = :address")})
public class AddressDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressSeqNum")
    private Long addressSeqNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "addressId")
    private String addressId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "userId")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "address")
    private String address;

    public AddressDb() {
    }

    public AddressDb(Long addressSeqNum) {
        this.addressSeqNum = addressSeqNum;
    }

    public AddressDb(Long addressSeqNum, String addressId, String userId, String address) {
        this.addressSeqNum = addressSeqNum;
        this.addressId = addressId;
        this.userId = userId;
        this.address = address;
    }

    public Long getAddressSeqNum() {
        return addressSeqNum;
    }

    public void setAddressSeqNum(Long addressSeqNum) {
        this.addressSeqNum = addressSeqNum;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressSeqNum != null ? addressSeqNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressDb)) {
            return false;
        }
        AddressDb other = (AddressDb) object;
        if ((this.addressSeqNum == null && other.addressSeqNum != null) || (this.addressSeqNum != null && !this.addressSeqNum.equals(other.addressSeqNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.AddressDb[ addressSeqNum=" + addressSeqNum + " ]";
    }
    
}

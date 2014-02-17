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
@Table(name = "moves_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovesDb.findAll", query = "SELECT m FROM MovesDb m"),
    @NamedQuery(name = "MovesDb.findByMoveSeqNum", query = "SELECT m FROM MovesDb m WHERE m.moveSeqNum = :moveSeqNum"),
    @NamedQuery(name = "MovesDb.findByMoveId", query = "SELECT m FROM MovesDb m WHERE m.moveId = :moveId"),
    @NamedQuery(name = "MovesDb.findBySmallBoxCount", query = "SELECT m FROM MovesDb m WHERE m.smallBoxCount = :smallBoxCount"),
    @NamedQuery(name = "MovesDb.findByMediumBoxCount", query = "SELECT m FROM MovesDb m WHERE m.mediumBoxCount = :mediumBoxCount"),
    @NamedQuery(name = "MovesDb.findByLargeBoxCount", query = "SELECT m FROM MovesDb m WHERE m.largeBoxCount = :largeBoxCount"),
    @NamedQuery(name = "MovesDb.findBySourceAddress", query = "SELECT m FROM MovesDb m WHERE m.sourceAddress = :sourceAddress"),
    @NamedQuery(name = "MovesDb.findByDestinationAddress", query = "SELECT m FROM MovesDb m WHERE m.destinationAddress = :destinationAddress"),
    @NamedQuery(name = "MovesDb.findByIsBigItemsPresent", query = "SELECT m FROM MovesDb m WHERE m.isBigItemsPresent = :isBigItemsPresent"),
    @NamedQuery(name = "MovesDb.findByDispatchDate", query = "SELECT m FROM MovesDb m WHERE m.dispatchDate = :dispatchDate"),
    @NamedQuery(name = "MovesDb.findByExpectedReceiveDate", query = "SELECT m FROM MovesDb m WHERE m.expectedReceiveDate = :expectedReceiveDate"),
    @NamedQuery(name = "MovesDb.findByUserId", query = "SELECT m FROM MovesDb m WHERE m.userId = :userId")})
public class MovesDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moveSeqNum")
    private Long moveSeqNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "moveId")
    private String moveId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smallBoxCount")
    private int smallBoxCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mediumBoxCount")
    private int mediumBoxCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "largeBoxCount")
    private int largeBoxCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "sourceAddress")
    private String sourceAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "destinationAddress")
    private String destinationAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isBigItemsPresent")
    private boolean isBigItemsPresent;
    @Size(max = 50)
    @Column(name = "dispatchDate")
    private String dispatchDate;
    @Size(max = 50)
    @Column(name = "expectedReceiveDate")
    private String expectedReceiveDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "userId")
    private String userId;

    public MovesDb() {
    }

    public MovesDb(Long moveSeqNum) {
        this.moveSeqNum = moveSeqNum;
    }

    public MovesDb(Long moveSeqNum, String moveId, int smallBoxCount, int mediumBoxCount, int largeBoxCount, String sourceAddress, String destinationAddress, boolean isBigItemsPresent, String userId) {
        this.moveSeqNum = moveSeqNum;
        this.moveId = moveId;
        this.smallBoxCount = smallBoxCount;
        this.mediumBoxCount = mediumBoxCount;
        this.largeBoxCount = largeBoxCount;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.isBigItemsPresent = isBigItemsPresent;
        this.userId = userId;
    }

    public Long getMoveSeqNum() {
        return moveSeqNum;
    }

    public void setMoveSeqNum(Long moveSeqNum) {
        this.moveSeqNum = moveSeqNum;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }

    public int getSmallBoxCount() {
        return smallBoxCount;
    }

    public void setSmallBoxCount(int smallBoxCount) {
        this.smallBoxCount = smallBoxCount;
    }

    public int getMediumBoxCount() {
        return mediumBoxCount;
    }

    public void setMediumBoxCount(int mediumBoxCount) {
        this.mediumBoxCount = mediumBoxCount;
    }

    public int getLargeBoxCount() {
        return largeBoxCount;
    }

    public void setLargeBoxCount(int largeBoxCount) {
        this.largeBoxCount = largeBoxCount;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public boolean getIsBigItemsPresent() {
        return isBigItemsPresent;
    }

    public void setIsBigItemsPresent(boolean isBigItemsPresent) {
        this.isBigItemsPresent = isBigItemsPresent;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getExpectedReceiveDate() {
        return expectedReceiveDate;
    }

    public void setExpectedReceiveDate(String expectedReceiveDate) {
        this.expectedReceiveDate = expectedReceiveDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moveSeqNum != null ? moveSeqNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovesDb)) {
            return false;
        }
        MovesDb other = (MovesDb) object;
        if ((this.moveSeqNum == null && other.moveSeqNum != null) || (this.moveSeqNum != null && !this.moveSeqNum.equals(other.moveSeqNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.MovesDb[ moveSeqNum=" + moveSeqNum + " ]";
    }
    
}

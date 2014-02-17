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
@Table(name = "bigitems_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BigitemsDb.findAll", query = "SELECT b FROM BigitemsDb b"),
    @NamedQuery(name = "BigitemsDb.findByBigItemSeqNum", query = "SELECT b FROM BigitemsDb b WHERE b.bigItemSeqNum = :bigItemSeqNum"),
    @NamedQuery(name = "BigitemsDb.findByBigItemId", query = "SELECT b FROM BigitemsDb b WHERE b.bigItemId = :bigItemId"),
    @NamedQuery(name = "BigitemsDb.findByMoveId", query = "SELECT b FROM BigitemsDb b WHERE b.moveId = :moveId"),
    @NamedQuery(name = "BigitemsDb.findByRequiresDisassembly", query = "SELECT b FROM BigitemsDb b WHERE b.requiresDisassembly = :requiresDisassembly"),
    @NamedQuery(name = "BigitemsDb.findByDoesFitInElevator", query = "SELECT b FROM BigitemsDb b WHERE b.doesFitInElevator = :doesFitInElevator"),
    @NamedQuery(name = "BigitemsDb.findByItemName", query = "SELECT b FROM BigitemsDb b WHERE b.itemName = :itemName"),
    @NamedQuery(name = "BigitemsDb.findByItemDescription", query = "SELECT b FROM BigitemsDb b WHERE b.itemDescription = :itemDescription"),
    @NamedQuery(name = "BigitemsDb.findByItemUrl", query = "SELECT b FROM BigitemsDb b WHERE b.itemUrl = :itemUrl")})
public class BigitemsDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bigItemSeqNum")
    private Long bigItemSeqNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "bigItemId")
    private String bigItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "moveId")
    private String moveId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiresDisassembly")
    private boolean requiresDisassembly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doesFitInElevator")
    private boolean doesFitInElevator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "itemDescription")
    private String itemDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "itemUrl")
    private String itemUrl;

    public BigitemsDb() {
    }

    public BigitemsDb(Long bigItemSeqNum) {
        this.bigItemSeqNum = bigItemSeqNum;
    }

    public BigitemsDb(Long bigItemSeqNum, String bigItemId, String moveId, boolean requiresDisassembly, boolean doesFitInElevator, String itemName, String itemDescription, String itemUrl) {
        this.bigItemSeqNum = bigItemSeqNum;
        this.bigItemId = bigItemId;
        this.moveId = moveId;
        this.requiresDisassembly = requiresDisassembly;
        this.doesFitInElevator = doesFitInElevator;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemUrl = itemUrl;
    }

    public Long getBigItemSeqNum() {
        return bigItemSeqNum;
    }

    public void setBigItemSeqNum(Long bigItemSeqNum) {
        this.bigItemSeqNum = bigItemSeqNum;
    }

    public String getBigItemId() {
        return bigItemId;
    }

    public void setBigItemId(String bigItemId) {
        this.bigItemId = bigItemId;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }

    public boolean getRequiresDisassembly() {
        return requiresDisassembly;
    }

    public void setRequiresDisassembly(boolean requiresDisassembly) {
        this.requiresDisassembly = requiresDisassembly;
    }

    public boolean getDoesFitInElevator() {
        return doesFitInElevator;
    }

    public void setDoesFitInElevator(boolean doesFitInElevator) {
        this.doesFitInElevator = doesFitInElevator;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bigItemSeqNum != null ? bigItemSeqNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BigitemsDb)) {
            return false;
        }
        BigitemsDb other = (BigitemsDb) object;
        if ((this.bigItemSeqNum == null && other.bigItemSeqNum != null) || (this.bigItemSeqNum != null && !this.bigItemSeqNum.equals(other.bigItemSeqNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.BigitemsDb[ bigItemSeqNum=" + bigItemSeqNum + " ]";
    }
    
}

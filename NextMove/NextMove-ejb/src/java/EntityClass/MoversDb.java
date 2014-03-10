/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aabuback
 */
@Entity
@Table(name = "movers_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoversDb.findAll", query = "SELECT m FROM MoversDb m"),
    @NamedQuery(name = "MoversDb.findByMoverSeqNum", query = "SELECT m FROM MoversDb m WHERE m.moverSeqNum = :moverSeqNum"),
    @NamedQuery(name = "MoversDb.findByMoverId", query = "SELECT m FROM MoversDb m WHERE m.moverId = :moverId"),
    @NamedQuery(name = "MoversDb.findByMoversName", query = "SELECT m FROM MoversDb m WHERE m.moversName = :moversName"),
    @NamedQuery(name = "MoversDb.findByMoversDescription", query = "SELECT m FROM MoversDb m WHERE m.moversDescription = :moversDescription"),
    @NamedQuery(name = "MoversDb.findByMoverEmail", query = "SELECT m FROM MoversDb m WHERE m.moverEmail = :moverEmail")})
public class MoversDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moverSeqNum")
    private Long moverSeqNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moverId")
    private String moverId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moversName")
    private String moversName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moversDescription")
    private String moversDescription;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "moversLocality")
    private String moversLocality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moverEmail")
    private String moverEmail;

    public MoversDb() {
    }

    public MoversDb(Long moverSeqNum) {
        this.moverSeqNum = moverSeqNum;
    }

    public MoversDb(Long moverSeqNum, String moverId, String moversName, String moversDescription, String moversLocality, String moverEmail) {
        this.moverSeqNum = moverSeqNum;
        this.moverId = moverId;
        this.moversName = moversName;
        this.moversDescription = moversDescription;
        this.moversLocality = moversLocality;
        this.moverEmail = moverEmail;
    }

    public Long getMoverSeqNum() {
        return moverSeqNum;
    }

    public void setMoverSeqNum(Long moverSeqNum) {
        this.moverSeqNum = moverSeqNum;
    }

    public String getMoverId() {
        return moverId;
    }

    public void setMoverId(String moverId) {
        this.moverId = moverId;
    }

    public String getMoversName() {
        return moversName;
    }

    public void setMoversName(String moversName) {
        this.moversName = moversName;
    }

    public String getMoversDescription() {
        return moversDescription;
    }

    public void setMoversDescription(String moversDescription) {
        this.moversDescription = moversDescription;
    }

    public String getMoversLocality() {
        return moversLocality;
    }

    public void setMoversLocality(String moversLocality) {
        this.moversLocality = moversLocality;
    }

    public String getMoverEmail() {
        return moverEmail;
    }

    public void setMoverEmail(String moverEmail) {
        this.moverEmail = moverEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moverSeqNum != null ? moverSeqNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoversDb)) {
            return false;
        }
        MoversDb other = (MoversDb) object;
        if ((this.moverSeqNum == null && other.moverSeqNum != null) || (this.moverSeqNum != null && !this.moverSeqNum.equals(other.moverSeqNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.MoversDb[ moverSeqNum=" + moverSeqNum + " ]";
    }
    
}

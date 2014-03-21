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
@Table(name = "mails_queue_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailsQueueDb.findAll", query = "SELECT m FROM MailsQueueDb m"),
    @NamedQuery(name = "MailsQueueDb.findByMailSeqNum", query = "SELECT m FROM MailsQueueDb m WHERE m.mailSeqNum = :mailSeqNum"),
    @NamedQuery(name = "MailsQueueDb.findByMoveId", query = "SELECT m FROM MailsQueueDb m WHERE m.moveId = :moveId"),
    @NamedQuery(name = "MailsQueueDb.findByMoverId", query = "SELECT m FROM MailsQueueDb m WHERE m.moverId = :moverId"),
    @NamedQuery(name = "MailsQueueDb.findByIsSent", query = "SELECT m FROM MailsQueueDb m WHERE m.isSent = :isSent"),
    @NamedQuery(name = "MailsQueueDb.findByMoverEmail", query = "SELECT m FROM MailsQueueDb m WHERE m.moverEmail = :moverEmail")})
public class MailsQueueDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mailSeqNum")
    private Long mailSeqNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moveId")
    private String moveId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moverId")
    private String moverId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "moveMail")
    private String moveMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isSent")
    private boolean isSent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "moverEmail")
    private String moverEmail;

    public MailsQueueDb() {
    }

    public MailsQueueDb(Long mailSeqNum) {
        this.mailSeqNum = mailSeqNum;
    }

    public MailsQueueDb(Long mailSeqNum, String moveId, String moverId, String moveMail, boolean isSent, String moverEmail) {
        this.mailSeqNum = mailSeqNum;
        this.moveId = moveId;
        this.moverId = moverId;
        this.moveMail = moveMail;
        this.isSent = isSent;
        this.moverEmail = moverEmail;
    }

    public Long getMailSeqNum() {
        return mailSeqNum;
    }

    public void setMailSeqNum(Long mailSeqNum) {
        this.mailSeqNum = mailSeqNum;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }

    public String getMoverId() {
        return moverId;
    }

    public void setMoverId(String moverId) {
        this.moverId = moverId;
    }

    public String getMoveMail() {
        return moveMail;
    }

    public void setMoveMail(String moveMail) {
        this.moveMail = moveMail;
    }

    public boolean getIsSent() {
        return isSent;
    }

    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
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
        hash += (mailSeqNum != null ? mailSeqNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailsQueueDb)) {
            return false;
        }
        MailsQueueDb other = (MailsQueueDb) object;
        if ((this.mailSeqNum == null && other.mailSeqNum != null) || (this.mailSeqNum != null && !this.mailSeqNum.equals(other.mailSeqNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.MailsQueueDb[ mailSeqNum=" + mailSeqNum + " ]";
    }
    
}

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
@Table(name = "box_type_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoxTypeDb.findAll", query = "SELECT b FROM BoxTypeDb b"),
    @NamedQuery(name = "BoxTypeDb.findByBoxTypeId", query = "SELECT b FROM BoxTypeDb b WHERE b.boxTypeId = :boxTypeId"),
    @NamedQuery(name = "BoxTypeDb.findByBoxType", query = "SELECT b FROM BoxTypeDb b WHERE b.boxType = :boxType"),
    @NamedQuery(name = "BoxTypeDb.findByBoxDescription", query = "SELECT b FROM BoxTypeDb b WHERE b.boxDescription = :boxDescription")})
public class BoxTypeDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "boxTypeId")
    private Long boxTypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boxType")
    private int boxType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "boxDescription")
    private String boxDescription;

    public BoxTypeDb() {
    }

    public BoxTypeDb(Long boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public BoxTypeDb(Long boxTypeId, int boxType, String boxDescription) {
        this.boxTypeId = boxTypeId;
        this.boxType = boxType;
        this.boxDescription = boxDescription;
    }

    public Long getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Long boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public int getBoxType() {
        return boxType;
    }

    public void setBoxType(int boxType) {
        this.boxType = boxType;
    }

    public String getBoxDescription() {
        return boxDescription;
    }

    public void setBoxDescription(String boxDescription) {
        this.boxDescription = boxDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boxTypeId != null ? boxTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoxTypeDb)) {
            return false;
        }
        BoxTypeDb other = (BoxTypeDb) object;
        if ((this.boxTypeId == null && other.boxTypeId != null) || (this.boxTypeId != null && !this.boxTypeId.equals(other.boxTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.BoxTypeDb[ boxTypeId=" + boxTypeId + " ]";
    }
    
}

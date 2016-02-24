package br.com.xyinc.xyincgps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POI")
public class POI implements Serializable{
	
	/**
	 * create by Rogério Josino Oliveira
	 */
	
	private static final long serialVersionUID = 4909462543366730533L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private Long id;
	
	@Column(name= "referenceX", nullable=false)
	private Integer referenceX;

	@Column(name= "referenceY", nullable=false)
	private Integer referenceY;
	
	@Column(name= "descriptionPOI", nullable=false, length=400)
	private String descriptionPOI;

	@Override
	public String toString() {
		return "POI [Referencia X=" + referenceX + ", Referencia Y=" + referenceY + " = Local:" + descriptionPOI + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getReferenceX() {
		return referenceX;
	}

	public void setReferenceX(Integer referenceX) {
		this.referenceX = referenceX;
	}

	public Integer getReferenceY() {
		return referenceY;
	}

	public void setReferenceY(Integer referenceY) {
		this.referenceY = referenceY;
	}

	public String getDescriptionPOI() {
		return descriptionPOI;
	}

	public void setDescriptionPOI(String descriptionPOI) {
		this.descriptionPOI = descriptionPOI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptionPOI == null) ? 0 : descriptionPOI.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((referenceX == null) ? 0 : referenceX.hashCode());
		result = prime * result + ((referenceY == null) ? 0 : referenceY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POI other = (POI) obj;
		if (descriptionPOI == null) {
			if (other.descriptionPOI != null)
				return false;
		} else if (!descriptionPOI.equals(other.descriptionPOI))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (referenceX == null) {
			if (other.referenceX != null)
				return false;
		} else if (!referenceX.equals(other.referenceX))
			return false;
		if (referenceY == null) {
			if (other.referenceY != null)
				return false;
		} else if (!referenceY.equals(other.referenceY))
			return false;
		return true;
	}
	
}

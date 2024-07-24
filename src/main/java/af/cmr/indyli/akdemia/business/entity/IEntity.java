package af.cmr.indyli.akdemia.business.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * This interface represents a generic entity in the system. It defines common
 * methods to retrieve and set the ID, creation date, and update date of an
 * entity.
 */
public interface IEntity extends Serializable {
	public Integer getId();

	public void setId(Integer id);

	public Date getCreationDate();

	public void setCreationDate(Date creationDate);

	public Date getUpdateDate();

	public void setUpdateDate(Date updateDate);

}

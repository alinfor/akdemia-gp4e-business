package af.cmr.indyli.akdemia.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Sub-Topic entity. It encapsulates information about a
 * specific sub-topic or area of focus within a broader topic.
 */
@Entity
@Table(name = "AKDEMIA_SUB_THEME")
public class SubTopic implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5840616928687527039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SUBTHEME_TITLE")
	private String subthemeTitle;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "compose", joinColumns = @JoinColumn(name = "ID_AKDEMIA_SUB_THEME"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<Topic> topics = new ArrayList<>();

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubthemeTitle() {
		return this.subthemeTitle;
	}

	public void setSubthemeTitle(String subthemeTitle) {
		this.subthemeTitle = subthemeTitle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDescription() {
		return this.description;
	}

	public List<Topic> getThemes() {
		return topics;
	}

	public void setThemes(List<Topic> topics) {
		this.topics = topics;
	}
}

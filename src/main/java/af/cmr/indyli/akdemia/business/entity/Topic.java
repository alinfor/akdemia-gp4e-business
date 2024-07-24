package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Topic entity. It encapsulates information relating to
 * the subject of the training.
 */
@Entity
@Table(name = "AKDEMIA_THEME")
public class Topic implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3845715988744528594L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "THEME_TITLE")
	private String themeTitle;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "compose", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_AKDEMIA_SUB_THEME"))
	private List<SubTopic> subTopics = new ArrayList<>();

	@Override
	public Integer getId() {
		return id;
	}

	public Topic() {
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getThemeTitle() {
		return this.themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public String getDescription() {
		return this.description;
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

	public List<SubTopic> getSubThemes() {
		return subTopics;
	}

	public void setSubThemes(List<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}

}

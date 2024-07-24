package af.cmr.indyli.akdemia.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKDEMIA_TRAINING")
public class Training implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2204270986869754275L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TRAINING_PRICE")
    private Double trainingPrice;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "ID_AKDEMIA_REQUIREMENT")
    private Requirement requirement;
 
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "content", joinColumns = @JoinColumn(name = "ID_AKDEMIA_TRAINING"), inverseJoinColumns = @JoinColumn(name = "ID"))
    private List<SubTopic> subTopics = new ArrayList<>();

	
	 @OneToMany(mappedBy = "training", fetch = FetchType.EAGER) private
	 List<Session> sessions = new ArrayList<>();
	 

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTrainingPrice() {
		return trainingPrice;
	}

	public void setTrainingPrice(Double trainingPrice) {
		this.trainingPrice = trainingPrice;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public List<SubTopic> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(List<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

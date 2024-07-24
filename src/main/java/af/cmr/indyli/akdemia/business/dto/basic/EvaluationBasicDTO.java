package af.cmr.indyli.akdemia.business.dto.basic;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Evaluation;

import java.util.Date;

/**
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link Evaluation} entity.
 */
public class EvaluationBasicDTO implements IDTO {
	private Integer id;
	private Integer sessionScore;
	private Integer trainerScore;
	private Date creationDate;
	private Date updateDate;

	public EvaluationBasicDTO() {
		super();
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSessionScore() {
		return sessionScore;
	}

	public void setSessionScore(Integer sessionScore) {
		this.sessionScore = sessionScore;
	}

	public Integer getTrainerScore() {
		return trainerScore;
	}

	public void setTrainerScore(Integer trainerScore) {
		this.trainerScore = trainerScore;
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

}

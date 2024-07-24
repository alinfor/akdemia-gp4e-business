package af.cmr.indyli.akdemia.business.dto.medium;


import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;

public class SessionMediumDTO extends SessionBasicDTO {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3920253315489480844L;
	private TrainerBasicDTO trainer;
	private TrainingBasicDTO training;
	
	
	/**
	 * @param trainer
	 * @param training
	 */
	public SessionMediumDTO() {
	}
	
	public TrainerBasicDTO getTrainer() {
		return trainer;
	}
	public void setTrainer(TrainerBasicDTO trainer) {
		this.trainer = trainer;
	}
	public TrainingBasicDTO getTraining() {
		return training;
	}
	public void setTraining(TrainingBasicDTO training) {
		this.training = training;
	}
	
}

package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;


public class InterSessionMediumDTO extends InterSessionBasicDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3612525194616976680L;
	private TrainerBasicDTO trainer;
	private TrainingBasicDTO training;
 
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

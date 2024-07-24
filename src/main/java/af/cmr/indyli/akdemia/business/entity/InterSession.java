package af.cmr.indyli.akdemia.business.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKDEMIA_INTER_SESSION")
public class InterSession extends Session {
	 

	
	@Column(name = "MIN_PARTICIPANTS")
	private Integer minParticipants;
 
	@OneToMany(mappedBy = "interSession", fetch = FetchType.EAGER)
	private List<ParticularSubscription> particularSubscriptions;
 
	public Integer getMinParticipants() {
		return minParticipants;
	}
 
	public void setMinParticipants(Integer minParticipants) {
		this.minParticipants = minParticipants;
	}
 
	public List<ParticularSubscription> getParticularSubscriptions() {
		return particularSubscriptions;
	}
 
	public void setParticularSubscriptions(List<ParticularSubscription> particularSubscriptions) {
		this.particularSubscriptions = particularSubscriptions;
	}



}

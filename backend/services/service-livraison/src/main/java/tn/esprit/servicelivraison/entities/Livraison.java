package tn.esprit.servicelivraison.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.servicelivraison.enums.LivraisonStatus;

@Entity
@Table(name = "livraison")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livraison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "orderId")
	private Long orderId;

	@Column
	private String address;

	@Column
	private String SecondAddress;

	@Column
	private String deliveryAgentName;

	@Column
	private String deliveryAgentNumber;

	@Column
	private LivraisonStatus status;
}

package tn.esprit.microserviceswallet.entities;


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

/**
 * This class represents a user entity, with basic properties like total, userId, userCode, credit ...
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@Entity
@Table(name = "wallet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private Double total;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "credit")
    private float credit;
    @Column(name = "debit")
    private float debit;


}





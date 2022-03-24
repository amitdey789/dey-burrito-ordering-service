package com.generali.burritoorderingservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="burrito_orders")
public class BurritoOrder {
	@Id
	@SequenceGenerator(name="seq_id", sequenceName="seq_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_id")
	private Long orderId;
	private String tortilla;
	private String protein;
	private String[] vegetables;
	private String salsa;
	private String[] extras;
	
	
	
}

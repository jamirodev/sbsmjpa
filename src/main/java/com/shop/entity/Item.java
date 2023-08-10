package com.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item")
public class Item extends BaseEntity {

	@Id
	@Column(name = "item_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_gen")
//	@SequenceGenerator(sequenceName = "seq_item_id", name = "item_id_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String itemNm;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stockNumber;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
}

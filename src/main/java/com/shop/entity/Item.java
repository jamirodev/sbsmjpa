package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import com.shop.excption.OutOfStockException;

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
	
	public void updateItem(ItemFormDto itemFormDto) {
		this.itemNm = itemFormDto.getItemNm();
		this.price = itemFormDto.getPrice();
		this.stockNumber = itemFormDto.getStockNumber();
		this.itemDetail = itemFormDto.getItemDetail();
		this.itemSellStatus = itemFormDto.getItemSellStatus();
	}
	
	public void removeStock(int stockNumber) {
		int restStock = this.stockNumber - stockNumber;
		if (restStock < 0) {
			throw new OutOfStockException("상품의 재고가 부족합니다.(현재 재고 수량: " + this.stockNumber + ")");
		}
		this.stockNumber = restStock;
	}
	
	public void addStock(int stockNumber) {
		this.stockNumber += stockNumber;
	}
	
}

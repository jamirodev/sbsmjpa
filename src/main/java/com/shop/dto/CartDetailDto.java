package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CartDetailDto {
	
	private Long cartItemId;
	
	private String itemNm;
	
	private Integer price;
	
	private Integer count;
	
	private String imgUrl;
	
//	public CartDetailDto(Long cartItemId, String itemNm, Integer price, Integer count, String imgUrl) {
//		this.cartItemId = cartItemId;
//		this.itemNm = itemNm;
//		this.price = price;
//		this.count = count;
//		this.imgUrl = imgUrl;
//	}
}

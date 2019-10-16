package com.imooc.product.emums;

import lombok.Getter;

/**
 * ResultEnum
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-12 23:31
 * Modified by:
 */
@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(1,"商品不存在"),
	PRODUCT_STOCK_ERROR(2,"库存有误"),
		;
	private Integer code;
	
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}

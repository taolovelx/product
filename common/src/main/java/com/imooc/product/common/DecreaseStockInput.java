package com.imooc.product.common;

import lombok.Data;

/**
 * DecreaseStockInput
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-15 15:08
 * Modified by:
 */
@Data
public class DecreaseStockInput {

	private String productId;

	private Integer productQuantity;

	public DecreaseStockInput() {
	}

	public DecreaseStockInput(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}

package com.imooc.product.service;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * ProductService
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-06 0:26
 * Modified by:
 */
public interface ProductService {
	/**
	 * 查询所有在加商品列表
	 */
	List<ProductInfo> findUpAll();

	/**
	 * 查询商品列表
	 * @return
	 */
	List<ProductInfoOutput> findList(List<String> productIdList);

	/**
	 * 扣库存
	 * @param decreaseStockInputList
	 */
	void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}

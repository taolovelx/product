package com.imooc.product.client;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * ProductClient
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-15 15:12
 * Modified by:
 */
@FeignClient(name = "product")
public interface ProductClient {

	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

	@PostMapping("/product/decreaseStock")
	void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}

package com.imooc.product.service.impl;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.emums.ProductStatusEnum;
import com.imooc.product.emums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ProductServiceImpl
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-06 0:29
 * Modified by:
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public List<ProductInfoOutput> findList(List<String> productIdList) {
		return productInfoRepository.findByProductIdIn(productIdList).stream()
				.map(e -> {
					ProductInfoOutput output = new ProductInfoOutput();
					BeanUtils.copyProperties(e, output);
					return output;
				})
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
		for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
			Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
			//判断商品是否存在
			if (!productInfoOptional.isPresent()){
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}

			ProductInfo productInfo = productInfoOptional.get();
			//库存是否足够
			Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
			if (result < 0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}

			productInfo.setProductStock(result);
			productInfoRepository.save(productInfo);
		}
	}
}

package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * ProductInfoRepositoryTest
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-04 23:10
 * Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Test
	public void findByProductStatus() {
		System.out.println(111);
		List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(productInfos.size() > 0);
	}

	@Test
	public void findByProductIdIn() throws Exception {
		List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
		Assert.assertTrue(list.size() > 0);
	}
}
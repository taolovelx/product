package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * CategoryServiceTest
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-06 1:24
 * Modified by:
 */
public class CategoryServiceTest extends ProductApplicationTests {
	
	@Autowired
	private CategoryService categoryService;

	@Test
	public void findByCategoryTypeIn() {

		List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
		assertTrue(byCategoryTypeIn.size() > 0);
	}
}
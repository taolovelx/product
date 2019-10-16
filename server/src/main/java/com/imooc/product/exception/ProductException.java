package com.imooc.product.exception;


import com.imooc.product.emums.ResultEnum;

/**
 * ProductException
 * Created by: renhaitao
 * Description:
 * Created in: 2019-10-12 23:26
 * Modified by:
 */
public class ProductException extends RuntimeException {
	
	private  Integer code;
	
	public ProductException(Integer code, String message){
		super(message);
	}

	public ProductException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}

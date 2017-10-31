package com.example.demo.service;

import org.springframework.stereotype.Component;

/**
 * 回调类ComputeClientHystrix，实现@FeignClient的接口，
 * 此时实现的方法就是对应@FeignClient接口中映射的fallback函数
* 
* 项目名称:  springCloudFeignHystrixConsumer1
* 包:       com.example.demo.service   
* 类名称:    ComputeClientHystrix.java
* 类描述:    
* 创建人:    yzx 
* 创建时间:  2017年10月31日
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

	public Integer add(Integer a, Integer b) {
		return -9999;
	}
}

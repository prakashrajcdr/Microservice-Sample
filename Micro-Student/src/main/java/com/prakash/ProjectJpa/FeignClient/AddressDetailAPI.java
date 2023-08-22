package com.prakash.ProjectJpa.FeignClient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "address-detail", path = "/address", url= "localhost:8081")
//@RibbonClient(name = "address-detail")
@FeignClient(name = "ADDRESS-SERVICE", path = "/address")
public interface AddressDetailAPI {

	@GetMapping("/getAddress/{id}")
	public Map<String, Object> getAddressDetailById(@PathVariable("id") Integer id);
}

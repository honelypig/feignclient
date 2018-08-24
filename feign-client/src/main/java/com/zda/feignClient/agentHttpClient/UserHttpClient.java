package com.zda.feignClient.agentHttpClient;

import java.util.List;

import javax.ws.rs.DELETE;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zda.feign.mycontract.MyUrl;
import com.zda.feignClient.dtos.ApiResult;
import com.zda.feignClient.dtos.Person;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
//如果是springcloud集群的话，可以写成@FeignClient(name="服务提供者spring.apprication.name的值")
//如果只是springboot的话，需要设置value与url，url的路径为接口地址，value可以自己设置
@FeignClient(value="myClient",url="${addr.serverUrl}")
public interface UserHttpClient {
	/*------------------get----------------------*/
	@GetMapping(value="list")
	public ApiResult<Person> getPerson(@RequestParam("msg")String msg);
	
	@GetMapping("Apilist")
	public ApiResult<List<Person>> getApiList(@RequestParam("msg") String msg, @RequestParam("val") String val);
	
	
	@RequestMapping(value = "Apilist/person", method = RequestMethod.GET, consumes="application/json")
	public ApiResult<List<Person>> getApiList( Person person,@RequestParam("msg")String msg);

	/*------------------post----------------------*/
	@PostMapping(consumes="application/json")
	public Person postBackPerson(Person p, @RequestParam("msg") String msg);
	@PostMapping(value="Apiresult", consumes="application/json")
	public ApiResult<Person> postBackApiresult(Person p, @RequestParam("msg") String msg);

	@PostMapping(value="Apiresultlist",consumes="application/json")
	public ApiResult<List<Person>> postBackApiresultList(Person p, @RequestParam("msg") String msg);

	/*------------------put----------------------*/
	@PutMapping(value="Person",consumes="application/json")
	public Person putPerson(Person p, @RequestParam("msg") String msg);

	@PutMapping(value="PersonList",consumes="application/json")
	public List<Person> putPersonList(List<Person> p, @RequestParam("msg") String msg);

	@PutMapping(value="ApiPersonList",consumes="application/json")
	public ApiResult<List<Person>> putApiPersonList(ApiResult<List<Person>> a, @RequestParam("msg") String msg);
	
	/*------------------delete----------------------*/
	@DeleteMapping(value="PersonList",consumes="application/json")
	public void deletePersonList(List<Person> p, @RequestParam("msg") String msg);
	/*------------------myurl----------------------*/
	@MyUrl(url = "/hellowd", method = "GET")
	public String myHello();
}

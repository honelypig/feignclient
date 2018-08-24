package com.zda.feignClient.agent;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zda.feignClient.dtos.ApiResult;
import com.zda.feignClient.dtos.Person;

import feign.Body;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface AllRequestClient {
	
/*	这个大括号要转码
 * @Body("%7B\"user_name\": \"{user_name}\", \"password\": \"{password}\"%7D")
 * 
 * @Headers("X-Ping: {token}")
 * 			设置请求，也可以用headerMap
 * 			//动态实现，这个void post(@Param("token") String token);
 * @RequestLine("PUT /all/putApiPersonList?msg={msg}") （' 参数  地址'）
 * 
 *  @HeaderMap 注解设置的请求头优先于其他方式设置的void post( @HeaderMap Map map);
 *  
	@QueryMap 会自动拼接到url上面的map参数void post( @QueryMap Map map);
	*/
	
	
	
	/*------------------get----------------------*/
	@RequestLine("GET /list?msg={msg}") // get參數必須這麼寫，否則會用post
	public List<Person> getList(@Param(value = "msg") String msg);

	@RequestLine("GET /Apilist?msg={msg}&val={val}")
	public ApiResult<List<Person>> getApiList(@Param("msg") String msg, @Param("val") String val);
	

	/*------------------post----------------------*/
	@RequestLine("POST /?msg={msg}")
	@Headers("Content-Type: application/json")
	public Person postBackPerson(Person p, @Param("msg") String msg);

	@RequestLine("POST /Apiresult?msg={msg}")
	@Headers("Content-Type: application/json")
	public ApiResult<Person> postBackApiresult(Person p, @Param("msg") String msg);
	

	@RequestLine("POST /Apiresultlist?msg={msg}")
	@Headers("Content-Type: application/json")
	public ApiResult<List<Person>> postBackApiresultList(Person p, @Param("msg") String msg);

	/*------------------put----------------------*/
	@RequestLine("PUT /Person?msg={msg}")
	@Headers("Content-Type: application/json")
	public Person putPerson(Person p, @Param("msg") String msg);

	@RequestLine("PUT /PersonList?msg={msg}")
	@Headers("Content-Type: application/json")
	public List<Person> putPersonList(List<Person> p, @Param("msg") String msg);

	@RequestLine("PUT /ApiPersonList?msg={msg}")
	@Headers("Content-Type: application/json")
	public ApiResult<List<Person>> putApiPersonList(ApiResult<List<Person>> a, @Param("msg") String msg);
	
	/*------------------delete----------------------*/
	@RequestLine("DELETE /PersonList?msg={msg}")
	@Headers("Content-Type: application/json")
	public void deletePersonList(List<Person> p, @Param("msg") String msg);
}

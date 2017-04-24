package ec.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* TODO
* 
* @coder ECHEN 
* @date 2016年5月16日 下午5:20:49
*/
@Controller
@RequestMapping("/")
public class IndexC extends BaseC{
	
	
	@RequestMapping(value={"/index","/"})
	@ResponseBody
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		return "index";
	}
	
	@RequestMapping(value={"/init"})
	@ResponseBody
	public String init(HttpServletRequest request,HttpServletResponse response) throws IOException{
		return "{\"code\":0,\"Version Name\":\"0.0.1\",\"Version Code\":1}";
	}
	
}

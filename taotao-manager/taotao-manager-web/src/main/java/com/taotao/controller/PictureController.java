package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;
/**
 * 上出图片处理
 * @author Arqea
 */ 

/*
 *  @RequestBody 将HTTP请求正文转换为适合的HttpMessageConverter对象。
 *  @ResponseBody 将内容或对象作为 HTTP 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。 
 */

@Controller 
public class PictureController { 
  @Autowired  
  private PictureService pictureService; 
  @RequestMapping("/pic/upload") 
  @ResponseBody //将java对象转换为字符串。相当于调用response对象，使用它的read方法，往客户端写值。
  
//  public Map pictureUpload(MultipartFile uploadFile) throws Exception{
//	  Map result=pictureService.uploadPicture(uploadFile);
//	  return result;
//  }
  public String  pictureUpload(MultipartFile uploadFile) throws Exception{
	   Map result=pictureService.uploadPicture(uploadFile);
	   //为了保证功能的兼容性，需要把Result转换为JSON格式的数据
	   String json=JsonUtils.objectToJson(result);
	   return json;
  }
}

package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;


@Controller
public class ItemController {
   @Autowired
   private ItemService itemService;
   @RequestMapping("/item/{itemId}")//配置url与方法的映射关系 
   @ResponseBody    //返回json格式的数据 
	public TbItem getItemById(@PathVariable Long itemId) {
		  
//	   //从路径中取参数     返回对象，将对象转换为json。  从路径中取参数使用@PathVariable注解
//	   /*
//	    * 如果 @RequestMapping("/item/{itemId}")中的itemId与  	public TbItem getItemById(@PathVariable Long itemId) {}中的itemId一致的话，不需要
//	    * 写value,否则写。
//	    * eg:
//	    * public String testPathVariable(@PathVariable(value="id") Integer id){	
//	    */
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
   @RequestMapping("/item/{itemId}")//配置url与方法的映射关系 
   @ResponseBody    //返回json格式的数据 
   public EUDataGridResult getItemList(Integer page,Integer rows)
   {
	   EUDataGridResult result= itemService.getItemList(page, rows);
	   return null;
   }
   
   @RequestMapping(value="/item/save",method=RequestMethod.POST)
   @ResponseBody
   private TaotaoResult createItem(TbItem item,String desc) throws Exception
   {
	 TaotaoResult result=itemService.createItem(item,desc, null);
	 return result;
   }
   
   
}
// 
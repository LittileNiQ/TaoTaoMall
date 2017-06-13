package com.taotao.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController{
   private ItemCatService itemCatService;
   @RequestMapping("/list")//配置url与方法的映射关系 
   @ResponseBody    //返回json格式的数据 
   public List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
	List<EUTreeNode> list=itemCatService.getCatList(parentId);
	return list;   
   }
}

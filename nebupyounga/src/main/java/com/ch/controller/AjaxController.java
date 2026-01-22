package com.ch.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ch.service.memberService;

@RestController
public class AjaxController {
	@Autowired
	memberService mSvc;
	
	@RequestMapping("ajax_buy_coding_class")
	public String codingClassBuy(@RequestBody Map<String,String>reqMap,HttpSession session) {
		String point = reqMap.get("point");
		String id = (String)session.getAttribute("id");
		mSvc.butCodingClass(id,point);
		session.removeAttribute("point");
		session.setAttribute("point", point);
		return point;
	}
	@RequestMapping("ajax_point_pp")
	public Map<String, String> pointpp(@RequestBody Map<String, String> reqMap, HttpSession session) {
	    Map<String, String> Map1 = new HashMap<>();
	    
	    int currentPoint = Integer.parseInt((String)session.getAttribute("point")); 
	    System.out.println(currentPoint);
	    int pp = (int)(Math.random() * 1000) + 1;
	    
	    int totalPoint = currentPoint + pp; // 실제 더하기 연산
	    
	    String id = (String)session.getAttribute("id");
	    
	    mSvc.butCodingClass(id, String.valueOf(totalPoint));
	    
	    Map1.put("plus", String.valueOf(pp));
	    Map1.put("point", String.valueOf(totalPoint));
		session.removeAttribute("point");
		session.setAttribute("point",String.valueOf(totalPoint) );
	    
	    return Map1;
	    }
	@RequestMapping("ajax_id_delete")
	public String ajaxIdDelete(@RequestBody Map<String,String>reqMap) {
		String id = (String)reqMap.get("id");
		mSvc.deleteId(id);
		return "삭제완";
	}

	
	
}

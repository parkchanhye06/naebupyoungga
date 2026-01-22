package com.ch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ch.dto.MemberDto;
import com.ch.service.SchedulerService;
import com.ch.service.memberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	memberService mSvc;
	
	@Autowired
    private SchedulerService schedulerService; // 작성하신 SchedulerImpl 주입

    private boolean isStarted = false; // 중복 실행 방지용 체크 변수
    
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	@RequestMapping("home")
	public String mainPage() {
		return "home";
		
	}
	@RequestMapping("loginCheck")
	public String loginCheck(String id,String pw,Model model,RedirectAttributes rttr,HttpSession session) {
		MemberDto mDto = mSvc.loginCheck(id, pw);
		List<MemberDto> mDtoList = new ArrayList<>();
		if(mDto==null) {
			rttr.addFlashAttribute("msg", "아이디/비밀번호를 다시 확인하세요");
			return "redirect:/";
		}else {
			if(mDto.getRole().equals("admin")) {
				session.setAttribute("id", mDto.getId());
				mDtoList = mSvc.selectAllMember();
				model.addAttribute("mDtoList",mDtoList);
				return "adminPage";
			}else {
			session.setAttribute("id", mDto.getId());
            session.setAttribute("name", mDto.getName());
            session.setAttribute("point", mDto.getPoint());
			return "redirect:/home";
			}
			
		}
		
	}
	@RequestMapping("signUp")
	public String signUp() {
		return "signUp";
	}
	@RequestMapping("signUpAction")
	public String signUpAction(String id,Model model,String pw,String name) {
		System.out.println("!!!");
		if(id==null ||pw==null ||name==null) {
			System.out.println("돌아가");
			model.addAttribute("msg","가입되었습니다.로그인 해주세요");
			return "signUp";
		}else {
			System.out.println("앞으로가");
			mSvc.signUpMember(id, pw, name);
			return "login";
		}
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "login";
	}
	@RequestMapping("idEdit")
	public String idEdit(@RequestParam("id") String id,
	        @RequestParam("pw") String pw,
	        @RequestParam("name") String name,
	        @RequestParam("point") String point,
	        Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("name",name);
		model.addAttribute("point",point);
		return"idEdit";
	}
	@RequestMapping("adminPage")
	public String adminPage(Model model, HttpSession session) {
		List<MemberDto> mDtoList = new ArrayList<>();
		model.addAttribute("msg","수정되었습니다");
		mDtoList = mSvc.selectAllMember();
		model.addAttribute("mDtoList",mDtoList);
		return "adminPage";
	}
	@RequestMapping("idEditAction")
	public String isEditAction(String id,String pw,String name,String point,RedirectAttributes rttr) {
		mSvc.idEdit(id, pw, name, point);
		return "redirect:/adminPage";
	}
	
	@RequestMapping(value = "/startScheduler", produces = "text/plain; charset=UTF-8") // 혹은 "/startScheduler" 같은 특정 주소
	@ResponseBody
	public String startScheduler() {
        if (!isStarted) {
            try {
                schedulerService.startScheduler();
                isStarted = true;
                System.out.println("<<< 스케줄러가 성공적으로 시작되었습니다! >>>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "스케줄러가 시작되었습니다.";
    }
	@RequestMapping(value = "/stopPlan", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String stopPlan() throws Exception {
	    schedulerService.endScheduler();
        System.out.println("<<< 스케줄러가 성공적으로 끝났습니다! >>>");
	    return "스케줄러가 중단되었습니다.";
	}
}

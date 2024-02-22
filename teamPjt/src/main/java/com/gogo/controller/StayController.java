package com.gogo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gogo.service.StayService;
import com.gogo.vo.StayVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stay/*")
public class StayController {

	private final StayService stayService;
	
	@GetMapping("list")
	public void getList(StayVO paramVO, Model model, HttpServletRequest request) {
		StayVO vo = new StayVO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memberId");
		if(id != null) {
			vo.setMemberId(id);
		}else {
			vo.setMemberId("");
		}
		if(!"undefined".equals(paramVO.getStayLoc()) || !"undefined".equals(paramVO.getStayType())) {
			stayService.stayLocList(paramVO, model);
		}else {
			stayService.stayList(model);
		}
		stayService.likeId(vo, model);
		stayService.stayImgList(model);
	}
	
	@GetMapping("room")
	public void roomInfo(String stayName , Model model, HttpServletRequest request) {
		stayService.stayRoomList(stayName, model);
		stayService.roomInfo(stayName, model);
		stayService.stayRoomImg(stayName, model);
		
		StayVO vo = new StayVO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memberId");
		if(id != null) {
			vo.setMemberId(id);
		}else {
			vo.setMemberId("");
		}
		stayService.likeId(vo, model);
	}
	
	@GetMapping("roomInfo")
	public void room(String stayName, String roomName, Model model) {
		stayService.roomInfoPageList(stayName, roomName, model);
		stayService.roomInfoPagePic(stayName, roomName, model);
	}
	
	@GetMapping("stayImg")
	public void stayImg(String stayName, Model model) {
		stayService.stayAllImg(stayName, model);
		stayService.roomAllImg(stayName, model);
	}
	
	
	
	/*
	 * @GetMapping("keyword") public void stayKeywordList(String , Model model) {
	 * stayService.stayKeywordList(vo, model); }
	 */
	/*
	 * @GetMapping("keyword") public void zz() {
	 * 
	 * }
	 */
}

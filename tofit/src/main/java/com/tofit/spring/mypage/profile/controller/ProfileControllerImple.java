package com.tofit.spring.mypage.profile.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.mypage.profile.service.ProfileService;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

@Controller("profileController")
public class ProfileControllerImple extends MultiActionController implements ProfileController {

	@Autowired
	private ProfileService profileService;
	@Autowired
	private ProfileVO profileVO;

	private static String PROFILEIMG_REPO = "D:\\KimSoYoung\\tofit\\profileImg";

	// 프로필 메인 페이지 로드
	@Override
	@RequestMapping(value = "/profile/profileInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView profileInfo(String _section, String _pageNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon")=="true") {
			String log_id = (String) session.getAttribute("log_id");
			int section = Integer.parseInt((_section == null) ? "1" : _section);
			int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
			ProfileVO profile = profileService.getProfile(log_id);
			Map pagingMap = new HashMap();
			pagingMap.put("id", log_id);
			pagingMap.put("section", section);
			pagingMap.put("pageNum", pageNum);
			Map myboardMap = profileService.getMyboard(pagingMap);
			myboardMap.put("section", section);
			myboardMap.put("pageNum", pageNum);
			mav.addObject("myboardMap", myboardMap);
			mav.addObject("profileInfo", profile);
			mav.setViewName("mypage/sub_mypage03");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 회원확인 페이지 로드
	@Override
	@RequestMapping(value = "/profile/gotoModi.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gotoModi(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			ProfileVO profile = profileService.getProfile(log_id);
			mav.addObject("profileInfo", profile);
			mav.setViewName("mypage/sub_mypage03_userCheck");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 회원 확인
	@Override
	@RequestMapping(value = "/profile/checkUser.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView checkUser(ProfileVO profileVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			ProfileVO profile = profileService.getProfile(log_id);
			String id = profile.getId();
			String pwd = profile.getPwd();
			boolean result = profileService.checkUser(profileVO);
			if (result) {
				mav.addObject("profileInfo", profile);
				mav.setViewName("mypage/sub_mypage03_profileModi");
			} else {
				mav.addObject("msg", "noMember");
				mav.addObject("profileInfo", profile);
				mav.setViewName("mypage/sub_mypage03_userCheck");
			}
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 프로필 수정
	@Override
	@RequestMapping(value = "/profile/modProfile.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity modProfile(MultipartHttpServletRequest multipartRequest, ProfileVO profileVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		if (session != null && session.getAttribute("isLogon") == "true") {
			multipartRequest.setCharacterEncoding("utf-8");
			Map<String, Object> proMap = new HashMap<String, Object>();
			Enumeration enu = multipartRequest.getParameterNames();
			while (enu.hasMoreElements()) {
				String name = (String) enu.nextElement();
				String value = multipartRequest.getParameter(name);
				proMap.put(name, value);
			}
			String newProfileImg = upload(multipartRequest);
			proMap.put("imageFileName", newProfileImg);
			try {
				if (newProfileImg != null && newProfileImg.length() != 0) {
					String originalImg = profileVO.getProfileImg();
					String id = profileVO.getId();
					profileVO.setProfileImg(newProfileImg);
					File srcFile = new File(PROFILEIMG_REPO + "\\temp\\" + newProfileImg);
					File destDir = new File(PROFILEIMG_REPO + "\\" + id);
					destDir.mkdir();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					File oldFile = new File(PROFILEIMG_REPO + "\\" + id + "\\" + originalImg);
					oldFile.delete();
				}
				profileService.modProfile(profileVO);
				message = "<script>";
				message += "alert('회원정보가 수정되었습니다.');";
				message += "location.href='" + multipartRequest.getContextPath() + "/profile/profileInfo.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			} catch (Exception e) {
				File srcFile = new File(PROFILEIMG_REPO + "\\temp\\" + newProfileImg);
				srcFile.delete();
				message = "<script>";
				message += "alert('오류가 발생했습니다. 다시 시도해주세요.');";
				message += "location.href='" + multipartRequest.getContextPath() + "/profile/profileInfo.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				e.printStackTrace();
			}
		} else {
			message = "<script>";
			message += "alert('로그인 해주세요');";
			message += "location.href='" + multipartRequest.getContextPath() + "/member/kitlogin.do';"; // index
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}

	// 회원탈퇴
	@Override
	@RequestMapping(value = "/profile/removeUser.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView removeUser(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			profileService.removeUser(log_id);
			File imgDir = new File(PROFILEIMG_REPO + "\\" + log_id);
			if (imgDir.exists()) {
				FileUtils.deleteDirectory(imgDir);
			}
			session.invalidate();
			redirectAttributes.addAttribute("msg", "removeUser");
			mav.setViewName("redirect:/common/index.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		String newProfileImg = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			newProfileImg = mFile.getOriginalFilename();
			File file = new File(PROFILEIMG_REPO + "\\temp\\" + fileName);
			if (mFile.getSize() != 0) {
				if (!file.exists()) {
					file.getParentFile().mkdirs();
					file.createNewFile();
				}
				mFile.transferTo(new File(PROFILEIMG_REPO + "\\temp\\" + newProfileImg));
			}
		}
		return newProfileImg;
	}
}

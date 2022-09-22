package kopo.poly.controller;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IUserService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MypController {
    //서비스로 연결
    @Resource(name = "UserService")
    private IUserService userService;

    @GetMapping(value = "/mypage/user-info")
    public String myUserInfo() throws Exception {
        log.info(this.getClass().getName()+".myUserInfo Start!!");
        log.info(this.getClass().getName()+".myUserInfo End!!");
        return "/mypage/user-info";
    }

    @GetMapping(value = "/mypage/myInfo")
    public String myInfoShow(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName() + ".myInfoShow Start!!");
        String user_seq = (String) session.getAttribute("sessionNo");
        log.info("user_seq : "+user_seq);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);

        UserInfoDTO rDTO = userService.getUserDetail(uDTO);
        if(rDTO == null){
            model.addAttribute("msg", "존재하지 않는 사용자입니다.");
            model.addAttribute("url", "index");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName() + ".myInfoShow End!!");
        return "/mypage/myInfo";
    }

    @GetMapping(value = "/mypage/myInfoUpdate")
    public String myInfoUpdate(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName()+".myInfoUpdate Start!!");

        String user_seq = (String) session.getAttribute("sessionNo");
        log.info("user_seq : "+user_seq);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);

        UserInfoDTO rDTO = userService.getUserDetail(uDTO);
        if(rDTO == null){
            model.addAttribute("msg", "존재하지 않는 사용자입니다.");
            model.addAttribute("url", "index");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);

        log.info(this.getClass().getName()+".myInfoUpdate End!!");
        return "/mypage/myInfoUpdate";
    }
    //내 정보 변경
    @PostMapping(value = "/mypage/userInfoUpdate")
    public String userInfoUpdate(HttpServletRequest request, Model model, HttpSession session) throws Exception{
        log.info(this.getClass().getName()+".userInfoUpdate End!!");
        String user_seq = (String) session.getAttribute("sessionNo");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_email = CmmUtil.nvl(request.getParameter("user_email"));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));
        String age = CmmUtil.nvl(request.getParameter("age"));
        String sex = CmmUtil.nvl(request.getParameter("sex"));
        log.info("user_seq : "+user_seq);

        /* 공백 체크 */
        if(user_id == "") {
            user_id = CmmUtil.nvl(request.getParameter("hidden_id"));
        }
        if(user_email == "") {
            user_email = CmmUtil.nvl(request.getParameter("hidden_email"));
        }
        if(user_name == "") {
            user_name = CmmUtil.nvl(request.getParameter("hidden_name"));
        }
        if(age == "") {
            age = CmmUtil.nvl(request.getParameter("hidden_age"));
        }
        if(sex == "") {
            sex = CmmUtil.nvl(request.getParameter("hidden_sex"));
        }
        log.info("user_id : "+user_id);
        log.info("user_email : "+user_email);
        log.info("user_name : "+user_name);
        log.info("age : "+age);
        log.info("sex : "+sex);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);
        uDTO.setUser_id(user_id);
        uDTO.setUser_email(user_email);
        uDTO.setUser_name(user_name);
        uDTO.setAge(age);
        uDTO.setSex(sex);

        int res = userService.getUserUpdate(uDTO);

        String msg, url = "/mypage/myInfo";
        if(res > 0) {
            msg = "정보 수정 성공";
            session.setAttribute("sessionId", user_name);
        } else {
            msg = "정보 수정 실패";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName()+".userInfoUpdate End!!");
        return "redirect";
    }
    // 내정보 비밀번호 변경
    @PostMapping(value = "/updateUserPw")
    public String updateUserPw(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + ".updateUserPw start");

        String msg = "";
        String url = "";

        String user_seq = CmmUtil.nvl(request.getParameter("sessionNo"));
        // 비밀번호 해시 알고리즘 암호화
        String user_pw = EncryptUtil.encHashSHA256(CmmUtil.nvl(request.getParameter("user_pw")));

        log.info("user_seq : " + user_seq);


        UserInfoDTO pDTO = new UserInfoDTO();
        pDTO.setUser_seq(user_seq);
        pDTO.setPassword(user_pw);

        int res = userService.updateUserPw(pDTO);

        if (res == 1) {
            msg = "성공적으로 비밀번호를 변경했습니다. 다시 로그인 해주세요";
            url = "/login/login";
        } else {
            msg = "비밀번호 저장에 실패했습니다.";
            url = "/mypage/updatePasswd";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".updateUserPw end");

        return "redirect";
    }
    @GetMapping(value = "/mypage/updatePasswd")
    public String updatePasswd(HttpSession session) {
        log.info(this.getClass().getName() + "loginStart");
        return "mypage/updatePasswd";
    }
}

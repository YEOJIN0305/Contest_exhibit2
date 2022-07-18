package kopo.poly.controller;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IUserService;
import kopo.poly.service.impl.UserService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {

    //서비스로 연결
    @Resource(name = "UserService")
    private IUserService userService;

    @GetMapping(value = "signUp")
    public String signUp() throws Exception {
        log.info(this.getClass().getName()+".signUp Start!!");
        log.info(this.getClass().getName()+".signUp End!!");
        return "userForm";
    }

    @GetMapping(value = "login")
    public String login() throws Exception {
        log.info(this.getClass().getName()+".login Start!!");
        log.info(this.getClass().getName()+".login End!!");
        return "login";
    }

    @PostMapping("userInsert")
    public String userInsert(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + ".getInsertUser Start!!");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_pwd = EncryptUtil.encHashSHA256(CmmUtil.nvl(request.getParameter("user_pwd")));
        String user_email = EncryptUtil.encAES128CBC(CmmUtil.nvl(request.getParameter("user_email")));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));

        log.info("받아온 아이디 : "+user_id);
        log.info("받아온 비번 : "+user_pwd);
        log.info("받아온 이메일 : "+user_email);
        log.info("받아온 이름 : "+user_name);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_id(user_id);
        uDTO.setUser_pwd(user_pwd);
        uDTO.setUser_email(user_email);
        uDTO.setUser_name(user_name);

        int res = userService.InsertUserInfo(uDTO);
        String msg;
        String url;

        if(res > 0){
            msg = "등록에 성공하셨습니다.";
            url = "/getNoticeList";
        } else {
            msg = "등록에 실패하셨습니다.";
            url = "/index";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".getInsertUser End!!");
        return "redirect";
    }

    @PostMapping(value = "userCheck")
    public String userCheck(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + ".userCheck Start!!");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_pwd = EncryptUtil.encHashSHA256(CmmUtil.nvl(request.getParameter("user_pwd")));

        log.info("받아온 아이디 : "+user_id);
        log.info("받아온 비번 : "+user_pwd);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_id(user_id);
        uDTO.setUser_pwd(user_pwd);

        UserInfoDTO rDTO = userService.ChkUserInfo(uDTO);
        String msg;
        String url;

        if(rDTO == null) {
            msg = "로그인에 실패하셨습니다.";
            url = "/index";
        } else {
            msg = "로그인에 성공하셨습니다.";
            url = "/getNoticeList";
            HttpSession session = request.getSession();
            String name = rDTO.getUser_name();
            String no = rDTO.getUser_seq();
            session.setAttribute("sessionId", name);
            session.setAttribute("sessionNo", no);
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".userCheck End!!");
        return "redirect";
    }

    @GetMapping(value = "logoutSession")
    public String logoutSession(HttpSession session, Model model) {
        log.info(this.getClass().getName() + ".logoutSession Start!!");

        session.invalidate();

        String msg = "로그아웃 되었습니다.";
        String url = "/getNoticeList";

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".logoutSession End!!");
        return "redirect";
    }

    @GetMapping(value = "userDelete")
    public String userDelete(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName() + ".userDelete Start!!");
        String user_seq = request.getParameter("uno");
        log.info("uno : "+user_seq);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);

        int res = userService.getUserDelete(uDTO);

        String msg, url = "/getNoticeList";
        if(res > 0) {
            msg = "회원 탈퇴 성공";
            session.invalidate();
        } else {
            msg = "회원 탈퇴 실패";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".userDelete End!!");
        return "redirect";
    }
}

package kopo.poly.controller;

import kopo.poly.dto.MailDTO;
import kopo.poly.dto.MemoDTO;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IMailService;
import kopo.poly.service.INoticeService;
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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class LoginController {
    //서비스로 연결
    @Resource(name = "UserService")
    private IUserService userService;
    //서비스로 연결
    @Resource(name = "NoticeService")
    private INoticeService noticeService;
    //메일 서비스 발송을 위한 쿼리
    @Resource(name = "MailService")
    private IMailService mailService;

    @GetMapping(value="/main-page")
    public String mainpage(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName()+".main-page Start!");
        String user_seq = (String) session.getAttribute("sessionNo");
        log.info("user_seq : "+user_seq);
/*
        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);
        UserInfoDTO rDTO = userService.getUserDetail(uDTO);*/

        List<NoticeDTO> rList = noticeService.getNoticeLimitThree();
        log.info("사이즈 : "+String.valueOf(rList.size()));
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList", rList);

        List<MemoDTO> memoList = noticeService.getNoticeMemoList();
        log.info("사이즈 : "+String.valueOf(memoList.size()));
        if(memoList == null){
            memoList = new ArrayList<>();
        }
        model.addAttribute("memoList", memoList);

        log.info(this.getClass().getName()+".main-page End!");
        return "/main-page";
    }

    @GetMapping(value="/login/forgot-id")
    public String authForgotId() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot id Start!");
        return "/login/forgot-id";
    }

    @GetMapping(value="/login/find-id")
    public String authFindId() throws Exception {
        log.info(this.getClass().getName()+".authFindId Start!");
        log.info(this.getClass().getName()+".authFindId End!");
        return "/login/find-id";
    }

    @GetMapping(value="/login/forgot-password")
    public String authForgot() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot Start!");
        return "/login/forgot-password";
    }

    @GetMapping(value="/login/login")
    public String authLogin() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot Start!");
        return "/login/login";
    }

    @GetMapping(value="/login/register")
    public String authRegister() throws Exception {
        log.info(this.getClass().getName()+".auth-register Start!");
        return "/login/register";
    }

    // 유저 ID찾기 ---> 이메일 전송
    @PostMapping(value = "forget_id")
    public String findID(HttpServletRequest request, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + ".findPw start!");

        String msg = "";
        String url = "";
        String icon = "";
        String contents = "";

        try {
            // 이메일 AES-128-CBC 암호화
            String user_name = CmmUtil.nvl(request.getParameter("user_name"));
            String user_email = CmmUtil.nvl(request.getParameter("user_email"));

            UserInfoDTO uDTO = new UserInfoDTO();

            uDTO.setUser_name(user_name);
            uDTO.setUser_email(user_email);
            log.info("user_name : " + user_name);
            log.info("user_email : " + user_email);

            UserInfoDTO rDTO = userService.findUserId(uDTO);

            log.info("rDTO : " + rDTO);
            if (rDTO != null) {
                String user_id = rDTO.getUser_id();
                msg = "아이디 찾기 성공!";
                icon = "success";
                contents = "해당하는 아이디 : " + user_id;
            } else {
                msg = "아이디 찾기 실패!";
                icon = "warning";
                contents = "이름과 이메일을 확인해주세요.";
            }
            url = "/login/login";


        } catch (Exception e) {
            msg = "서버 오류입니다.";
            url = "/forget_id";
            log.info(e.toString());
            e.printStackTrace();
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        model.addAttribute("icon", icon);
        model.addAttribute("contents", contents);

        log.info(this.getClass().getName() + ".findPw end!");

        return "redirect";
    }

    // 유저 비밀번호 찾기 --> 새비밀번호 전송 (비밀번호를모를때)
    @PostMapping(value = "forget_pwd")
    public String findPw(HttpServletRequest request, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + ".findPw start!");

        String msg = "";
        String url = "";
        String icon = "";
        String contents = "";

        try {

            String newPW = String.valueOf((int) (Math.random() * 1000000));

            // 이메일 AES-128-CBC 암호화
            String user_email = CmmUtil.nvl(request.getParameter("user_email"));
            String user_id = CmmUtil.nvl(request.getParameter("user_id"));
            // 비밀번호 해시 알고리즘 암호화
            String user_pw = EncryptUtil.encHashSHA256(newPW);

            UserInfoDTO pDTO = new UserInfoDTO();
            pDTO.setPassword(user_pw);
            pDTO.setUser_email(user_email);
            pDTO.setUser_id(user_id);
            log.info("user_email : " + user_email);
            log.info("user_pw : " + user_pw);
            log.info("user_id :" + user_id );

            int res = userService.updateUserPw(pDTO);
            log.info("res : " + res);

            if (res == 1) {

                MailDTO rDTO = new MailDTO();
                rDTO.setToMail(user_email);
                log.info("email : " + user_email);
                rDTO.setTitle("######의 새비밀번호 전송!!!");
                rDTO.setContents("new password : " + newPW);
                log.info("newPW : " + newPW);

                int mailRes = mailService.doSendMail(rDTO);

                if (mailRes == 1) {
                    msg = "비밀 번호 변경 성공!";
                    icon = "success";
                    contents = "새 비밀번호를 이메일로 발송했습니다. 로그인 후 변경해주세요.";
                } else {
                    msg = "비밀 번호 변경 실패!";
                    icon = "warning";
                    contents = "변경된 비밀번호 발송에 실패했습니다. ####@naver.com 으로 문의해주세요.";
                }
                url = "/login";

            } else if (res == 0) {
                msg = "정보를 다시 확인해주세요.";
                icon = "warning";
                contents = "정확한 정보를 입력해주세요!";
            }

        } catch (Exception e) {
            msg = "서버 오류입니다.";
            icon = "warning";
            contents = "서버 오류입니다 관리자에게 문의해주세요";
            log.info(e.toString());
            e.printStackTrace();
        }
        model.addAttribute("msg", msg);
        log.info(url);
        model.addAttribute("url", url);
        model.addAttribute("icon", icon);
        model.addAttribute("contents",contents);

        log.info(this.getClass().getName() + ".findPw end!");

        return "redirect";
    }

}

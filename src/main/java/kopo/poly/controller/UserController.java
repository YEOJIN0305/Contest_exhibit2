package kopo.poly.controller;

import kopo.poly.dto.GoogleOAuthRequest;
import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IMailService;
import kopo.poly.service.IUserService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {

    //서비스로 연결
    @Resource(name = "UserService")
    private IUserService userService;

    //메일 서비스 발송을 위한 쿼리
    @Resource(name = "MailService")
    private IMailService mailService;

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
    public String userInsert(HttpServletRequest request, HttpServletRequest response, Model model) throws Exception {
        log.info(this.getClass().getName() + ".getInsertUser Start!!");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String password = EncryptUtil.encHashSHA256(CmmUtil.nvl(request.getParameter("user_pwd")));
        String user_email = CmmUtil.nvl(request.getParameter("user_email"));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));
        String age = CmmUtil.nvl(request.getParameter("user_age"));
        String sex = CmmUtil.nvl(request.getParameter("sex"));

        log.info("받아온 아이디 : " + user_id);
        log.info("받아온 비번 : " + password);
        log.info("받아온 이메일 : " + user_email);
        log.info("받아온 이름 : " + user_name);
        log.info("받아온 나이 : " + age);
        log.info("받아온 나이 : " + sex);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_id(user_id);
        uDTO.setPassword(password);
        uDTO.setUser_email(user_email);
        uDTO.setUser_name(user_name);
        uDTO.setAge(age);
        uDTO.setSex(sex);

        int res = userService.InsertUserInfo(uDTO);
        String msg;
        String url;
        String icon;

        if (res > 0) {
            msg = "등록에 성공하셨습니다.";
            icon = "success";
            url = "/login/login";
        } else {
            msg = "등록에 실패하셨습니다.";
            icon = "fail";
            url = "/login/register";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + ".getInsertUser End!!");
        return "redirect";
    }

    @PostMapping(value = "userCheck")
    public String userCheck(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName() + ".userCheck Start!!");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String password = EncryptUtil.encHashSHA256(CmmUtil.nvl(request.getParameter("user_pwd")));
        String msg;
        String url;
        String icon;

        log.info("받아온 아이디 : " + user_id);
        log.info("받아온 비번 : " + password);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_id(user_id);
        uDTO.setPassword(password);

        UserInfoDTO rDTO = userService.ChkUserInfo(uDTO);
        log.info("로그인 조회 결과는 :" + rDTO);

        if (rDTO == null) {
            msg = "로그인에 실패하셨습니다.";
            icon = "fail";
            url = "/login/login";
        } else {
            msg = "로그인에 성공하셨습니다.";
            icon = "success";
            url = "/main-page";
            String name = rDTO.getUser_name();
            String no = rDTO.getUser_seq();
            session.setAttribute("sessionId", name);
            session.setAttribute("sessionNo", no);
            log.info("sessionID : " + name);
            log.info("sessionSEQ : " + no);
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        model.addAttribute("icon", icon);

        log.info(this.getClass().getName() + ".userCheck End!!");
        return "redirect";
    }

    @GetMapping(value = "logoutSession")
    public String logoutSession(HttpSession session, Model model) {
        log.info(this.getClass().getName() + ".logoutSession Start!!");

        session.invalidate();

        String msg = "로그아웃 되었습니다.";
        String url = "/login/login";

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

    @GetMapping(value = "myInfo")
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
        return "myInfo";
    }

    @PostMapping(value = "myInfoUpdate")
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
        return "myInfoUpdate";
    }
    @PostMapping(value = "userInfoUpdate")
    public String userInfoUpdate(HttpServletRequest request, Model model, HttpSession session) throws Exception{
        log.info(this.getClass().getName()+".userInfoUpdate End!!");
        String user_seq = (String) session.getAttribute("sessionNo");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_email = EncryptUtil.encAES128CBC(CmmUtil.nvl(request.getParameter("user_email")));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));
        log.info("user_seq : "+user_seq);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);
        uDTO.setUser_id(user_id);
        uDTO.setUser_email(user_email);
        uDTO.setUser_name(user_name);

        int res = userService.getUserUpdate(uDTO);

        String msg, url = "/myInfo";
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

    @GetMapping(value = "findID")
    public String findID(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + ".findID Start!!");
        String user_email = EncryptUtil.encAES128CBC(CmmUtil.nvl(request.getParameter("user_email")));
        log.info("user_email : "+user_email);
/*
        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_email(user_email);

        UserInfoDTO rDTO = userService.getUserDetail(uDTO);
        if(rDTO == null){
            model.addAttribute("msg", "존재하지 않는 사용자입니다.");
            model.addAttribute("url", "index");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);*/
        log.info(this.getClass().getName() + ".findID End!!");
        return "/login/find-id";
    }

    /* sns login*/
    @Value("google.auth.url")
    private String googleAuthUrl;

    @Value("google.login.url")
    private String googleLoginUrl;

    @Value("google.redirect.url")
    private String googleRedirectUrl;

    @Value("google.client.id")
    private String googleClientId;

    @Value("google.secret")
    private String googleClientSecret;


    // 구글 로그인창 호출
    @RequestMapping(value = "/getGoogleAuthUrl")
    public @ResponseBody
    String getGoogleAuthUrl(HttpServletRequest request) throws Exception {

        String reqUrl = googleLoginUrl + "/o/oauth2/v2/auth?client_id=" + googleClientId + "&redirect_uri=" + googleRedirectUrl
                + "&response_type=code&scope=email%20profile%20openid&access_type=offline";

        return reqUrl;
    }


    // 구글 연동정보 조회
    @RequestMapping(value = "/login/oauth_google")
    public String oauth_google(HttpServletRequest request, @RequestParam(value = "code") String authCode, HttpServletResponse response) throws Exception {

        // restTemplate 호출
        RestTemplate restTemplate = new RestTemplate();

        GoogleOAuthRequest googleOAuthRequestParam = GoogleOAuthRequest
                .builder()
                .clientId(googleClientId)
                .clientSecret(googleClientSecret)
                .code(authCode)
                .redirectUri(googleRedirectUrl + "/login/oauth_google")
                .grantType("authorization_code")
                .build();

        ResponseEntity<JSONObject> apiResponse = restTemplate.postForEntity(googleAuthUrl + "/token", googleOAuthRequestParam, JSONObject.class);
        JSONObject responseBody = apiResponse.getBody();

        log.info(String.valueOf(responseBody));
        //   id_token은 jwt 형식
        //String jwtToken = responseBody.get("id_token");
        //String requestUrl = UriComponentsBuilder.fromHttpUrl(googleAuthUrl + "/tokeninfo").queryParam("id_token", jwtToken).toUriString();
/*
        JSONObject resultJson = restTemplate.getForObject(requestUrl, JSONObject.class);

        // 구글 정보조회 성공
        if (resultJson != null) {

            //  회원 고유 식별자
            //String googleUniqueNo = resultJson.getString("sub");


            /*

             TO DO : 리턴받은 googleUniqueNo 해당하는 회원정보 조회 후 로그인 처리 후 메인으로 이동

             */

            //return jwtToken;
            // 구글 정보조회 실패
//        } else {
//            throw new Error("구글 정보조회에 실패했습니다.");
//            return jwtToken;
//        }
        return null;
    }
}

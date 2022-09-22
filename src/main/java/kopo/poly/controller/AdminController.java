package kopo.poly.controller;

import kopo.poly.dto.CmuDTO;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.IAdminService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AdminController {
    @Resource(name = "AdminService")
    private IAdminService adminService;

    //회원관리, 게시판 관리 버튼
    @GetMapping(value = "Admin_01")
    public String admin_01() throws Exception {
        log.info(this.getClass().getName() + " .Admin_01 Start !!");
        log.info(this.getClass().getName() + " .Admin_01 End !!");
        return "/admin/Admin_01";
    }

    //회원 관리
    @GetMapping(value = "Admin_02")
    public String admin_02(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .Admin_02 Start !!");

        List<UserInfoDTO> uList = adminService.getUserList();
        log.info("사이즈 : "+String.valueOf(uList.size()));
        if(uList == null){
            uList = new ArrayList<>();
        }
        model.addAttribute("uList", uList);

        log.info(this.getClass().getName() + " .Admin_02 End !!");

        return "/admin/Admin_02";
    }

    /** 회원관리-수정/삭제 */
    @GetMapping(value = "/admin/Admin_03")
    public String admin_03(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .Admin_03 Start !!");

        String user_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("user_seq : " + user_seq);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);

        UserInfoDTO rDTO = adminService.getAdminDetail(uDTO);

        if (rDTO == null) {
            model.addAttribute("msg", "존재하지 않는 사용자입니다.");
            model.addAttribute("url", "Admin_02");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);

        log.info(this.getClass().getName() + " .Admin_03 End !!");

        return "/admin/Admin_03";
    }

    /** 회원관리-검색 */
    @GetMapping(value = "/admin/search")
    public String searchUserName(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .searchUserName Start !!");
        String keyword = CmmUtil.nvl(request.getParameter("keyword"));
        log.info("user 이름 : "+keyword);

        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_name(keyword);

        UserInfoDTO rDTO = adminService.getSearchUser(uDTO);

        if (rDTO == null) {
            model.addAttribute("msg", "존재하지 않는 사용자입니다.");
            model.addAttribute("url", "Admin_02");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName() + " .searchUserName Start !!");
        return "Admin_02";
    }

    //커뮤니티 관리
    @GetMapping(value = "Admin_04")
    public String admin_04() throws Exception {
        log.info(this.getClass().getName() + " .Admin_04 Start !!");
        log.info(this.getClass().getName() + " .Admin_04 End !!");

        return "/admin/Admin_04";
    }
}

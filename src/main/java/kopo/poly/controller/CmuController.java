package kopo.poly.controller;

import kopo.poly.dto.AnnouncementDTO;
import kopo.poly.dto.CmuDTO;
import kopo.poly.dto.QuestionDTO;
import kopo.poly.service.ICmuService;
import kopo.poly.service.impl.CmuService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CmuController {

    @Resource(name = "CmuService")
    private ICmuService cmuService;

    //게시글 등록
    @RequestMapping(value = "getInsertCmu")
    public String getInsertCmu(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName() + " .getInsertCmu Start !!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        String id = (String) session.getAttribute("sessionId");
        log.info("id : " + id);
        log.info("title : " + title);
        log.info("contents : " + contents);

        CmuDTO cDTO = new CmuDTO();
        cDTO.setTitle(title);
        cDTO.setContents(contents);
        //cDTO.setId(id);

        int res = cmuService.InsertCmuInfo(cDTO);

        String msg;
        String url = "/getCmuList";

        if (res > 0) {
            msg = "등록되었습니다";
        } else {
            msg = "등록에 실패했습니다";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + " .getInsertCmu End !!");
        return "redirect";
    }

    @RequestMapping(value = "getCmuList")
    public String getCmuList(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getCmuList Start !!");

        List<CmuDTO> cList = cmuService.getCmuList();

        if (cList == null) {
            cList = new ArrayList<>();
        }

        model.addAttribute("cList", cList);

        log.info(this.getClass().getName() + " .getCmuList End !!");

        return "/cmu/Cmu_01";
    }

    //게시판 메인 페이지
    @GetMapping(value = "/cmu/Cmu_01")
    public String cmu_01(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .Cmu_01 Start !!");

        List<CmuDTO> cList = cmuService.getCmuList();

        model.addAttribute("cList", cList);

        log.info(this.getClass().getName() + " .Cmu_01 End !!");

        return "/cmu/Cmu_01";
    }

    //게시글 등록
    @GetMapping(value = "/cmu/Cmu_02")
    public String cmu_02() throws Exception {
        log.info(this.getClass().getName() + " .Cmu_02 Start !!");
        log.info(this.getClass().getName() + " .Cmu_02 End !!");

        return "/cmu/Cmu_02";
    }

    //게시글 상세보기
    @GetMapping(value = "/cmu/Cmu_03")
    public String cmu_03(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .CmuDetail Start !!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq : " + notice_seq);

        CmuDTO cDTO = new CmuDTO();
        cDTO.setNotice_seq(Integer.parseInt(notice_seq));

        CmuDTO rDTO = cmuService.getCmuDetail(cDTO);


        if (rDTO == null) {
            model.addAttribute("msg", "존재하지 않는 게시물입니다");
            model.addAttribute("url", "getCmuList");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName() + " .CmuDetail End !!");

        return "/cmu/Cmu_03";
    }

    //게시글 수정
    @GetMapping(value = "/cmu/Cmu_04")
    public String cmu_04(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .Cmu_04 Start !!");

        String notice_seq = CmmUtil.nvl(request.getParameter("no"));

        CmuDTO cDTO = new CmuDTO();
        cDTO.setNotice_seq(Integer.parseInt(notice_seq));

        CmuDTO rDTO = cmuService.getCmuDetail(cDTO);

        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName() + " .Cmu_04 End !!");

        return "/cmu/Cmu_04";
    }

    @GetMapping(value = "CmuDelete")
    public String cmuDelete(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .noticeDelete Start !!");
        /*url에서 'no'로 보내기 때문에 컨트롤러에서 'no'로 받는다*/
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq : " + notice_seq);

        CmuDTO cDTO = new CmuDTO();
        cDTO.setNotice_seq(Integer.parseInt(notice_seq));

        int res = cmuService.cmuDelete(cDTO);
        String msg;
        String url;

        if (res == 1) {
            msg = "삭제되었습니다";
            url = "getCmuList";
        } else {
            msg = "삭제에 실패했습니다";
            url = "CmuDetail?no=" + notice_seq;
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        return "redirect";

    }

    //업데이트 페이지 띄우기
    @GetMapping(value = "CmuUpdate")
    public String noticeUpdate(HttpServletRequest request, ModelMap model) throws Exception {
        String notice_seq = request.getParameter("no");
        model.addAttribute("notice_seq", notice_seq);

        return "Cmu_04";
    }

    @GetMapping(value = "DoCmuUpdate")
    public String doCmuUpdate(HttpServletRequest request, Model model) throws Exception {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        String notice_seq = request.getParameter("notice_seq");

        log.info("받아온 제목 : " + title);
        log.info("받아온 내용 : " + contents);
        log.info("받아온 번호 : " + notice_seq);

        CmuDTO cDTO = new CmuDTO();
        cDTO.setNotice_seq(Integer.parseInt(notice_seq));
        cDTO.setTitle(title);
        cDTO.setContents(contents);

        int res = cmuService.cmuUpdate(cDTO);

        String msg;
        String url;
        if (res > 0) {
            msg = "수정되었습니다";
            url = "getCmuList";
        } else {
            msg = "수정에 실패했습니다";
            url = "getCmuList";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);


        return "redirect";
    }

    @GetMapping(value = "/cmu/question")
    public String question(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .question Start !!");

        List<QuestionDTO> qList = cmuService.getQuestionList();

        model.addAttribute("qList", qList);

        log.info(this.getClass().getName() + " .question End !!");

        return "/cmu/question";
    }

    @GetMapping(value = "/cmu/announcement")
    public String announcement(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .announcement Start !!");

        List<AnnouncementDTO> aList = cmuService.getAnnouncementList();

        model.addAttribute("aList", aList);

        log.info(this.getClass().getName() + " .announcement End !!");

        return "/cmu/announcement";
    }
}

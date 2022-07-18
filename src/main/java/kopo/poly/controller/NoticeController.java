package kopo.poly.controller;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class NoticeController {

    //서비스로 연결
    @Resource(name = "NoticeService")
    private INoticeService noticeService;

    @GetMapping(value = "index")
    public String indexPage() throws Exception {
        log.info(this.getClass().getName()+".indexPage Start!!");
        log.info(this.getClass().getName()+".indexPage End!!");
        return "index";
    }

    // form.jsp 화면 띄워주는 url
    @GetMapping(value = "noticeInfo")
    public String noticeInfo() throws Exception {
        log.info(this.getClass().getName()+".noticeInfo Start!!");
        log.info(this.getClass().getName()+".noticeInfo End!!");
        return "form";
    }

    //form.jsp에서 전송 누를 시
    @PostMapping(value = "getNoticeData")
    public String getNoticeData (HttpServletRequest request, Model model) throws Exception {
        /*
          HttpServletRequest : 클라이언트의 요청에 관한 정보를 내장시킴
          (예: form.jsp를 통해 보낸 게시판 제목, 게시판 내용)
          Model : HashMap 형태로 뷰에 값을 전달할 수 있음
          request.getParameter() : HttpServletRequest 객체의 데이터를 꺼내기 위해 사용
          model.addAttribute() : Model 객체에 데이터를 저장하고 뷰에 값을 전달하기 위해 사용
         */
        log.info(this.getClass().getName()+".getNoticeData Start!!");
        //폼에서 데이터를 갖고온 뒤 공백 제거 후 변수에 저장
        String title = CmmUtil.nvl(request.getParameter("title"));
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("title : "+title);
        log.info("reg_id : "+reg_id);
        log.info("contents : "+contents);

        //저장된 값을 모델에 넣어줌
        model.addAttribute("title", title);
        model.addAttribute("reg_id", reg_id);
        model.addAttribute("contents", contents);

        log.info(this.getClass().getName()+".getNoticeData End!!");
        //getNoticeData.jsp로 이동
        return "getNoticeData";
    }

    @PostMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName()+".getInsertNotice Start!!");
        //request.getParameter로 사용자가 입력한 값을 갖고옴
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("title : "+title);
        log.info("reg_id : "+reg_id);
        log.info("contents : "+contents);

        //DTO에 값을 담아줌
        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setTitle(title);
        pDTO.setReg_id(reg_id);
        pDTO.setContents(contents);
        
        //서비스로 연결(이후 매퍼->DB->result를 거쳐 옴) -> res가 1/0으로 처리 결과 성공/실패 여부 판단
        int res = noticeService.InsertNoticeInfo(pDTO);

        String msg, url = "/getNoticeList";

        if(res>0){
            msg = "등록 성공";
        } else {
            msg = "등록 실패";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName()+".getInsertNotice End!!");
        return "redirect";
    }

    @RequestMapping(value = "getNoticeList")
    public String getNoticeList(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName()+".getNoticeList Start!!");

        List<NoticeDTO> rList = noticeService.getNoticeList();
        log.info("사이즈 : "+String.valueOf(rList.size()));
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList", rList);

        log.info(this.getClass().getName()+".getNoticeList End!!");

        return "noticeList";
    }

    @RequestMapping(value = "noticeDetail")
    public String NoticeDetail(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName()+".NoticeDetail Start!!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq Null Chk : "+notice_seq);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(notice_seq);

        NoticeDTO rDTO = noticeService.getNoticeDetail(pDTO);
        if(rDTO == null){
            model.addAttribute("msg", "존재하지 않는 게시물입니다.");
            model.addAttribute("url", "getNoticeList");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName()+".NoticeDetail End!!");

        return "noticeDetail";
    }

    @RequestMapping(value = "noticeDelete")
    public String noticeDelete(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName()+".noticeDelete Start!!");
        /*url에서 'no'로 보내기 때문에 컨트롤러에서 'no'로 받는다.*/
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq : "+notice_seq);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(notice_seq);

        int res = noticeService.getNoticeDelete(pDTO);
        //저장되면 1의 값을 안되면 0의 값을 가져옴

        String msg;
        String url;

        if(res > 0){
            msg = "삭제에 성공하셨습니다.";
            url = "getNoticeList";
        } else {
            msg = "삭제에 실패하셨습니다.";
            url = "noticeDetail?no="+notice_seq;
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName()+".noticeDelete End!!");
        return "redirect";
    }

    @GetMapping(value = "noticeUpdate")
    public String noticeUpdate(HttpServletRequest request, ModelMap model) throws Exception{
        String Notice_seq = request.getParameter("no");
        log.info(Notice_seq);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(Notice_seq);

        NoticeDTO rDTO = noticeService.noticeUpdate(pDTO);
        if(rDTO == null){
            model.addAttribute("msg", "존재하지 않는 게시물입니다.");
            model.addAttribute("url", "getNoticeList");
            return "redirect";
        }
        model.addAttribute("rDTO", rDTO);

        return "editForm";
    }
    @PostMapping(value = "DoNoticeUpdate")
    public String DoNoticeUpdate(HttpServletRequest request, Model model) throws Exception {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        String notice_seq = request.getParameter("notice_seq");
        log.info("받아온 번호 : "+notice_seq);
        log.info("받아온 제목 : "+title);
        log.info("받아온 내용 : "+contents);

        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setNotice_seq(notice_seq);
        nDTO.setTitle(title);
        nDTO.setContents(contents);

        int res = noticeService.getNoticeUpdate(nDTO);

        String msg;
        String url = "noticeDetail?no="+notice_seq;

        if(res > 0){
            msg = "수정에 성공하셨습니다.";
        } else {
            msg = "수정에 실패하셨습니다.";

        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName()+".DoNoticeUpdate End!!");
        return "redirect";
    }

}

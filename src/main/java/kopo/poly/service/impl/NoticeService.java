package kopo.poly.service.impl;

import kopo.poly.dto.MemoDTO;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
//서비스는 컨트롤에서 자신을 찾을 수 있도록 반드시 자신의 이름을 기입함
@Service("NoticeService")
//또한 자기 이름 앞에 I를 붙인 인터페이스를 생성하고 구현(Implements)함
public class NoticeService implements INoticeService {
    /*
    - 서비스 역할 -
    Controller로 부터 전달받은 정보(DTO, 회원정보)를 가지고 프로그래밍 처리
    데이터 베이스로부터 값을 Insert, Update, Delete, Select 할 경우
    데이터베이스(오라클)와 연동하는 Mapper들을 호출
    여러 개의 Mapper들은 Service의 한 개의 함수에서 호출 가능
    중요 로직 처리는 Controller가 아닌 Service단에서 함
    */

    private final INoticeMapper noticeMapper;

    @Autowired
    public NoticeService(INoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    @Override
    public int InsertNoticeInfo(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName()+".InsertNoticeInfo Start!!");
        int res = noticeMapper.InsertNoticeInfo(pDTO);
        log.info(this.getClass().getName()+".InsertNoticeInfo End!!");
        return res;
    }

    @Override
    public List<NoticeDTO> getNoticeList() throws Exception{
        log.info(this.getClass().getName()+".getNoticeList start!");
        List<NoticeDTO> rList = noticeMapper.getNoticeList();
        log.info(this.getClass().getName()+".getNoticeList End!");
        return rList;
    }

    @Override
    public NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName()+".getNoticeDetail start!");
        NoticeDTO rDTO = noticeMapper.getNoticeDetail(pDTO);
        log.info(this.getClass().getName()+".getNoticeDetail End!");
        return rDTO;
    }

    @Override
    public int getNoticeDelete(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName()+".getNoticeDelete start!");
        int res = noticeMapper.getNoticeDelete(pDTO);
        log.info(this.getClass().getName()+".getNoticeDelete End!");
        return res;
    }

    @Override
    public NoticeDTO noticeUpdate(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName()+".noticeUpdate start!");
        NoticeDTO rDTO = noticeMapper.noticeUpdate(nDTO);
        log.info(this.getClass().getName()+".noticeUpdate End!");
        return rDTO;
    }

    @Override
    public int getNoticeUpdate(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName()+".getNoticeUpdate start!");
        int res = noticeMapper.getNoticeUpdate(nDTO);
        log.info(this.getClass().getName()+".getNoticeUpdate End!");
        return res;
    }

    @Override
    public List<NoticeDTO> getNoticeLimitThree() throws Exception {
        log.info(this.getClass().getName()+".getNoticeLimitThree start!");
        List<NoticeDTO> rList = noticeMapper.getNoticeLimitThree();
        log.info(this.getClass().getName()+".getNoticeLimitThree End!");
        return rList;
    }

    @Override
    public List<MemoDTO> getNoticeMemoList() throws Exception {
        log.info(this.getClass().getName()+".getNoticeMemoList start!");
        List<MemoDTO> rList = noticeMapper.getNoticeMemoList();
        log.info(this.getClass().getName()+".getNoticeMemoList End!");
        return rList;
    }

}

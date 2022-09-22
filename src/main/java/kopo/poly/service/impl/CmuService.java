package kopo.poly.service.impl;

import kopo.poly.dto.AnnouncementDTO;
import kopo.poly.dto.CmuDTO;
import kopo.poly.dto.QuestionDTO;
import kopo.poly.persistance.mapper.ICmuMapper;
import kopo.poly.service.ICmuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("CmuService")
public class CmuService implements ICmuService {

    private ICmuMapper cmuMapper;

    @Autowired
    public CmuService(ICmuMapper cmuMapper) {this.cmuMapper = cmuMapper;}

    @Override
    public int InsertCmuInfo(CmuDTO cDTO) throws Exception{

        log.info(this.getClass().getName() + "InsertCmuInfo start !!");
        log.info(this.getClass().getName() + "InsertCmuInfo end !!");
        return cmuMapper.InsertCmuInfo(cDTO);
    }

    @Override
    public List<CmuDTO> getCmuList() throws Exception {
        return cmuMapper.getCmuList();
    }

    @Override
    public int cmuDelete(CmuDTO cDTO) throws Exception {
        int res = cmuMapper.cmuDelete(cDTO);
        return res;
    }

    @Override
    public int cmuUpdate(CmuDTO cDTO) throws Exception {
        int res = cmuMapper.cmuUpdate(cDTO);
        return res;
    }

    @Override
    public CmuDTO getCmuDetail(CmuDTO cDTO) throws Exception {
        log.info(this.getClass().getName() + " .getCmuDetail Start !!");
        CmuDTO rDTO = cmuMapper.getCmuDetail(cDTO);
        log.info(this.getClass().getName() + " .getCmuDetail End !!");
        return rDTO;
    }

    @Override
    public List<QuestionDTO> getQuestionList() throws Exception {
        return cmuMapper.getQuestionList();
    }

    @Override
    public List<AnnouncementDTO> getAnnouncementList() throws Exception {
        return cmuMapper.getAnnouncementList();
    }


}

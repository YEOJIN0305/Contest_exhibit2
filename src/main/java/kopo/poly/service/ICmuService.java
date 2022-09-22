package kopo.poly.service;

import kopo.poly.dto.AnnouncementDTO;
import kopo.poly.dto.CmuDTO;
import kopo.poly.dto.QuestionDTO;

import java.util.List;

public interface ICmuService {
    int InsertCmuInfo(CmuDTO rDTO) throws Exception;

    List<CmuDTO> getCmuList() throws Exception;

    int cmuDelete(CmuDTO cDTO) throws Exception;

    int cmuUpdate(CmuDTO cDTO) throws Exception;

    CmuDTO getCmuDetail(CmuDTO cDTO) throws Exception;

    List<QuestionDTO> getQuestionList() throws Exception;

    List<AnnouncementDTO> getAnnouncementList() throws Exception;
}

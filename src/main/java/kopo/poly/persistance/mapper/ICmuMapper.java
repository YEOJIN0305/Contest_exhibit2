package kopo.poly.persistance.mapper;

import kopo.poly.dto.AnnouncementDTO;
import kopo.poly.dto.CmuDTO;
import kopo.poly.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICmuMapper {

    int InsertCmuInfo(CmuDTO cDTO) throws Exception;

    List<CmuDTO> getCmuList() throws Exception;

    int cmuDelete(CmuDTO cDTO) throws Exception;

    int cmuUpdate(CmuDTO cDTO) throws Exception;

    CmuDTO getCmuDetail(CmuDTO cDTO) throws Exception;

    List<QuestionDTO> getQuestionList() throws Exception;

    List<AnnouncementDTO> getAnnouncementList() throws Exception;
}

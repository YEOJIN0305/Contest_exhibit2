package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAdminMapper {

    List<UserInfoDTO> getUserList() throws Exception;

    UserInfoDTO getAdminDetail(UserInfoDTO uDTO) throws Exception;
}

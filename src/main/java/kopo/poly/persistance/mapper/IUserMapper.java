package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    int InsertUserInfo(UserInfoDTO uDTO) throws Exception;

    UserInfoDTO ChkUserInfo(UserInfoDTO uDTO) throws Exception;

    int getUserDelete(UserInfoDTO uDTO) throws Exception;

    UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception;

    int getUserUpdate(UserInfoDTO uDTO) throws Exception;

    //유저 아이디찾기
    UserInfoDTO findUserId(UserInfoDTO pDTO);
    // 유저 비밀번호 변경
    int updateUserPw(UserInfoDTO pDTO) throws Exception;
}

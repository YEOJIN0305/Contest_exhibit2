package kopo.poly.service;

import kopo.poly.dto.UserInfoDTO;

public interface IUserService {
    int InsertUserInfo(UserInfoDTO uDTO) throws Exception;

    UserInfoDTO ChkUserInfo(UserInfoDTO uDTO) throws Exception;

    int getUserDelete(UserInfoDTO uDTO) throws Exception;
}

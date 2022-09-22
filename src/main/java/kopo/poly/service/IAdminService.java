package kopo.poly.service;

import kopo.poly.dto.UserInfoDTO;

import java.util.List;

public interface IAdminService {
    List<UserInfoDTO> getUserList() throws Exception;

    UserInfoDTO getAdminDetail(UserInfoDTO uDTO) throws Exception;

    UserInfoDTO getSearchUser(UserInfoDTO uDTO);
}

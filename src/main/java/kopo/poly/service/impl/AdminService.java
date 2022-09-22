package kopo.poly.service.impl;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.persistance.mapper.IAdminMapper;
import kopo.poly.persistance.mapper.ICmuMapper;
import kopo.poly.service.IAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service("AdminService")
public class AdminService implements IAdminService {

    private final IAdminMapper adminMapper;

    @Override
    public List<UserInfoDTO> getUserList() throws Exception {
        return adminMapper.getUserList();
    }

    @Override
    public UserInfoDTO getAdminDetail(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".InsertUserInfo start!");
        UserInfoDTO iDTO = adminMapper.getAdminDetail(uDTO);
        log.info(this.getClass().getName()+".InsertUserInfo end!");
        return iDTO;
    }

    @Override
    public UserInfoDTO getSearchUser(UserInfoDTO uDTO) {
        return null;
    }
}

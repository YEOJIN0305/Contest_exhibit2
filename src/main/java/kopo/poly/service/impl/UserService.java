package kopo.poly.service.impl;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.persistance.mapper.IUserMapper;
import kopo.poly.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("UserService")
public class UserService implements IUserService {

    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int InsertUserInfo(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".InsertUserInfo start!");
        int res = userMapper.InsertUserInfo(uDTO);
        log.info(this.getClass().getName()+".InsertUserInfo end!");
        return res;
    }

    @Override
    public UserInfoDTO ChkUserInfo(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".InsertUserInfo start!");
        UserInfoDTO iDTO = userMapper.ChkUserInfo(uDTO);
        log.info(this.getClass().getName()+".InsertUserInfo end!");
        return iDTO;
    }

    @Override
    public int getUserDelete(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".getUserDelete start!");
        int res = userMapper.getUserDelete(uDTO);
        log.info(this.getClass().getName()+".getUserDelete end!");
        return res;
    }

    @Override
    public UserInfoDTO getUserDetail(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".getUserDetail start!");
        UserInfoDTO iDTO = userMapper.getUserDetail(uDTO);
        log.info(this.getClass().getName()+".getUserDetail end!");
        return iDTO;
    }

    @Override
    public int getUserUpdate(UserInfoDTO uDTO) throws Exception {
        log.info(this.getClass().getName()+".getUserUpdate start!");
        int res = userMapper.getUserUpdate(uDTO);
        log.info(this.getClass().getName()+".getUserUpdate end!");
        return res;
    }
    //아이디 찾기
    @Override
    public UserInfoDTO findUserId(UserInfoDTO pDTO) {
        log.info(this.getClass().getName() + ".findUserId start");

        if(pDTO ==null) {
            pDTO = new UserInfoDTO();
            log.info("DTO가 널값으로 넘어옴");
        }else {
            log.info("잘 넘어감");
        }

        UserInfoDTO rDTO= userMapper.findUserId(pDTO);

        log.info(this.getClass().getName() + ".findUserId end");

        return rDTO;
    }
    //비밀번호 변경
    @Override
    public int updateUserPw(UserInfoDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateUserPw start");

        if(pDTO ==null) {
            pDTO = new UserInfoDTO();
            log.info("DTO가 널값으로 넘어옴");
        }

        int res = userMapper.updateUserPw(pDTO);

        log.info("res : " + res);

        log.info(this.getClass().getName() + ".updateUserPw end");

        return res;
    }
}

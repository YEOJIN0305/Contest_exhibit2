package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private String user_seq;
    private String user_id;
    private String password;
    private String user_email;
    private String user_name;
    private String age;
    private String sex;
}
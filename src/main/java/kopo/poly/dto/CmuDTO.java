package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CmuDTO {
    private int notice_seq;
    private int notice_yn;
    private String user_seq;
    private String user_name;
    private String update_user_seq;
    private String notice_date;
    private String update_id;
    private String title;
    private String contents;
    private String update_date;
}

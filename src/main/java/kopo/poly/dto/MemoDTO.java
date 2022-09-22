package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDTO {
    private String memo_seq;
    private String title;
    private String contents;
    private String reg_date;
}

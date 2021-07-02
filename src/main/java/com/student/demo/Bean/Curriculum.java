package com.student.demo.Bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Curriculum {
    //周一
    private String MMOAT;
    private String MMTAF;
    private String MAOAT;
    private String MATAF;
    //周二
    private String TMOAT;
    private String TMTAF;
    private String TAOAT;
    private String TATAF;
    //周三
    private String WMOAT;
    private String WMTAF;
    private String WAOAT;
    private String WATAF;
    //周四
    private String THMOAT;
    private String THMTAF;
    private String THAOAT;
    private String THATAF;
    //周五
    private String FMOAT;
    private String FMTAF;
    private String FAOAT;
    private String FATAF;
    //周六
    private String SMOAT;
    private String SMTAF;
    private String SAOAT;
    private String SATAF;
    //周日
    private String SOMOAT;
    private String SOMTAF;
    private String SOAOAT;
    private String SOATAF;



}

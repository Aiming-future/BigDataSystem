package cn.com.chinahitech.market.visual.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

//job_news
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("job_news")
public class Bar4 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String jobname;
    private String money;
    private  String region;
    private  String degree;
    private  String comname;
    private  String type;
    private  String date;






}


package cn.com.chinahitech.market.visual.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

//top10岗位数量地区
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("top10_job")
public class Bar1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private int y;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getData() {
        return y;
    }



}


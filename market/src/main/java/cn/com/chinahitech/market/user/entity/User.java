package cn.com.chinahitech.market.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghui
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String name;

    @TableField("openId")
    private String openId;

    private String accid;

    private String token;

    private String weixinname;

    private String weixinid;

    private String weixinpic;

    @TableField("phoneNumber")
    private String phoneNumber;

    private String registdate;

    private String updatedate;

    @TableField("QRcodepath")
    private String QRcodepath;

    private Integer parentid;

    private Integer userlevel;

    private Integer teamnum;

    private Integer straightpush;

    private Integer userclient;

    private String other1;

    private String other2;


}

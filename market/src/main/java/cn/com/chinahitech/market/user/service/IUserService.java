package cn.com.chinahitech.market.user.service;

import cn.com.chinahitech.market.user.entity.User;
import cn.com.chinahitech.market.user.exception.UserQueryException;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanghui
 * @since 2020-06-22
 */
public interface IUserService extends IService<User> {

    List<User> getUserByName(String name) throws UserQueryException;

}

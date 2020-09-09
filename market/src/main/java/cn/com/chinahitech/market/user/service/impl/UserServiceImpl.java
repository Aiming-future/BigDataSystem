package cn.com.chinahitech.market.user.service.impl;

import cn.com.chinahitech.market.user.entity.User;
import cn.com.chinahitech.market.user.exception.UserQueryException;
import cn.com.chinahitech.market.user.mapper.UserMapper;
import cn.com.chinahitech.market.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghui
 * @since 2020-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> getUserByName(String name) throws UserQueryException {
        List<User> list = null;
        try{
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.like("name", name);
            list = list(wrapper);

        }catch(Exception ex){
            throw new UserQueryException("用户查询错误");
        }
        return list;
    }
}

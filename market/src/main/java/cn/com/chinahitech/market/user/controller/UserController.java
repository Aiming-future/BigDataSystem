package cn.com.chinahitech.market.user.controller;


import cn.com.chinahitech.market.user.entity.User;
import cn.com.chinahitech.market.user.exception.UserQueryException;
import cn.com.chinahitech.market.user.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghui
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getuserbyname", method = RequestMethod.POST)
    public JSONObject getUserByName(String name){
        JSONObject jsonObj = new JSONObject();
        List<User> userList = null;
        try{
            if(name == null || name.equals("")){
                jsonObj.put("errorcode", "20002");
                jsonObj.put("errormsg", "姓名不能为空");
                return jsonObj;
            }
            userList = userService.getUserByName(name);
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", userList);
        }catch(UserQueryException ex){
            jsonObj.put("errorcode", "20001");
            jsonObj.put("errormsg", ex.getMessage());
        }
        return jsonObj;
    }

}

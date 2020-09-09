package cn.com.chinahitech.market.visual.controller;


import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.util.TableName;
import cn.com.chinahitech.market.visual.entity.Pie;
import cn.com.chinahitech.market.visual.entity.Pie1;
import cn.com.chinahitech.market.visual.entity.Pie2;
import cn.com.chinahitech.market.visual.service.IPieService;
import cn.com.chinahitech.market.visual.service.impl.PieServiceImpl;
import cn.com.chinahitech.market.visual.service.impl.PieServiceImpl1;
import cn.com.chinahitech.market.visual.service.impl.PieServiceImpl2;
import net.sf.json.JSONObject;
import net.sf.jsqlparser.schema.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visual")
@CrossOrigin
public class PieController {


    @Qualifier("pieServiceImpl")
    @Autowired
    private IPieService pieService;
    @RequestMapping(value = "/pie", method = RequestMethod.GET)
    public JSONObject getData(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Pie> pieList = pieService.getData();
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", pieList);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("pieServiceImpl1")
    @Autowired
    private IPieService pieService1;


    @RequestMapping(value = "/pie1", method = RequestMethod.GET)
    public JSONObject getData1(){
        JSONObject jsonObj = new JSONObject();
        try {

            List<Pie1> pieList = pieService1.getData();
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", pieList);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("pieServiceImpl2")
    @Autowired
    private IPieService pieService2;


    @RequestMapping(value = "/pie2", method = RequestMethod.GET)
    public JSONObject getData2(){
        JSONObject jsonObj = new JSONObject();
        try {

            List<Pie2> pieList = pieService2.getData();
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", pieList);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }




}

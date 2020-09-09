package cn.com.chinahitech.market.visual.controller;


import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.*;
import cn.com.chinahitech.market.visual.service.IPieService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/visual")
@CrossOrigin
public class BarController {


    @Qualifier("barServiceImpl")
    @Autowired
    private IPieService pieService;
    @RequestMapping(value = "/Bar", method = RequestMethod.GET)
    public JSONObject getData(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Bar> pieList = pieService.getData();
            int len=pieList.size();
            List<Bar0> bar0List=new ArrayList<Bar0>(len);

            Bar bar;
            for(int i=0;i<len;i++)
            {
                Bar0 temp=new Bar0();
                bar=pieList.get(i);
                temp.setName(bar.getName());
                temp.setId(bar.getId());
                int a[]={bar.getData()
                };
                temp.setData(a);
                bar0List.add(temp);


            }

            jsonObj.put("errorcode", "0");
            jsonObj.put("data", bar0List);
            jsonObj.put("data1", bar0List);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("barServiceImpl1")
    @Autowired
    private IPieService pieService1;
    @RequestMapping(value = "/Bar1", method = RequestMethod.GET)
    public JSONObject getData1(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Bar> pieList = pieService1.getData();
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", pieList);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("barServiceImpl2")
    @Autowired
    private IPieService pieService2;
    @RequestMapping(value = "/Bar2", method = RequestMethod.GET)
    public JSONObject getData2(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Bar2> pieList = pieService2.getData();
            int len=pieList.size();
            String []name=new String[len];
            int[][]salary=new int[len][2];
            String s;
            int min,max;
            for(int i=0;i<len;i++)
            {
                name[i]=pieList.get(i).getName();
                s=pieList.get(i).getData();
                min=Integer.valueOf(s.substring(0,s.indexOf("-")));
                max=Integer.valueOf(s.substring(s.indexOf("-")+1,s.indexOf("k")));
                salary[i][0]=min;
                salary[i][1]=max;

            }
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", salary);
            jsonObj.put("name",name);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("barServiceImpl3")
    @Autowired
    private IPieService pieService3;
    @RequestMapping(value = "/Bar3", method = RequestMethod.GET)
    public JSONObject getData3(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Bar3> pieList = pieService3.getData();
            int len=pieList.size();
            String []name=new String[len];
            int[][]salary=new int[len][2];
            String s;
            int min,max;
            for(int i=0;i<len;i++)
            {
                name[i]=pieList.get(i).getName();
                s=pieList.get(i).getData();
                min=Integer.valueOf(s.substring(0,s.indexOf("-")));
                max=Integer.valueOf(s.substring(s.indexOf("-")+1,s.indexOf("k")));
                salary[i][0]=min;
                salary[i][1]=max;

            }
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", salary);
            jsonObj.put("name",name);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }

    @Qualifier("barServiceImpl4")
    @Autowired
    private IPieService pieService4;
    @RequestMapping(value = "/Bar4", method = RequestMethod.GET)
    public JSONObject getData4(){


        JSONObject jsonObj = new JSONObject();
        try {

            List<Bar4> pieList = pieService4.getData();
            jsonObj.put("errorcode", "0");
            jsonObj.put("data", pieList);
        } catch (QueryException e) {
            jsonObj.put("errorcode", "30001");
            jsonObj.put("errormsg", e.getMessage());
        }
        return jsonObj;
    }


}

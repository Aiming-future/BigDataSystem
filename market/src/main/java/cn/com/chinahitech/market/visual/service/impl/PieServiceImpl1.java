package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Pie;
import cn.com.chinahitech.market.visual.entity.Pie1;
import cn.com.chinahitech.market.visual.entity.Pie2;
import cn.com.chinahitech.market.visual.mapper.PieMapper;
import cn.com.chinahitech.market.visual.mapper.PieMapper1;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PieServiceImpl1 extends ServiceImpl<PieMapper1, Pie1> implements IPieService<Pie1> {


    @Override
    public List<Pie1> getData() throws QueryException {
        List<Pie1> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }


}

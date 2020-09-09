package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Pie;
import cn.com.chinahitech.market.visual.entity.Pie1;
import cn.com.chinahitech.market.visual.entity.Pie2;
import cn.com.chinahitech.market.visual.mapper.PieMapper;
import cn.com.chinahitech.market.visual.mapper.PieMapper2;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PieServiceImpl2 extends ServiceImpl<PieMapper2, Pie2> implements IPieService<Pie2> {


    @Override
    public List<Pie2> getData() throws QueryException {
        List<Pie2> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }

}

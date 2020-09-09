package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Bar;
import cn.com.chinahitech.market.visual.entity.Bar1;
import cn.com.chinahitech.market.visual.mapper.BarMapper;
import cn.com.chinahitech.market.visual.mapper.BarMapper1;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BarServiceImpl1 extends ServiceImpl<BarMapper1, Bar1> implements IPieService<Bar1> {

    @Override
    public List<Bar1> getData() throws QueryException {
        List<Bar1> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }

}

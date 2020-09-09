package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Bar2;
import cn.com.chinahitech.market.visual.entity.Bar3;
import cn.com.chinahitech.market.visual.mapper.BarMapper2;
import cn.com.chinahitech.market.visual.mapper.BarMapper3;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BarServiceImpl3 extends ServiceImpl<BarMapper3, Bar3> implements IPieService<Bar3> {

    @Override
    public List<Bar3> getData() throws QueryException {
        List<Bar3> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }

}

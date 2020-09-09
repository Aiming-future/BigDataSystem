package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Bar1;
import cn.com.chinahitech.market.visual.entity.Bar2;
import cn.com.chinahitech.market.visual.mapper.BarMapper1;
import cn.com.chinahitech.market.visual.mapper.BarMapper2;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BarServiceImpl2 extends ServiceImpl<BarMapper2, Bar2> implements IPieService<Bar2> {

    @Override
    public List<Bar2> getData() throws QueryException {
        List<Bar2> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }

}

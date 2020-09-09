package cn.com.chinahitech.market.visual.service.impl;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Bar3;
import cn.com.chinahitech.market.visual.entity.Bar4;
import cn.com.chinahitech.market.visual.mapper.BarMapper3;
import cn.com.chinahitech.market.visual.mapper.BarMapper4;
import cn.com.chinahitech.market.visual.service.IPieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BarServiceImpl4 extends ServiceImpl<BarMapper4, Bar4> implements IPieService<Bar4> {

    @Override
    public List<Bar4> getData() throws QueryException {
        List<Bar4> pieList = null;
        try {
            pieList = list();
        }catch(Exception ex){
            throw new QueryException("数据查询错误");
        }
        return pieList;
    }

}

package cn.com.chinahitech.market.visual.service;

import cn.com.chinahitech.market.exception.QueryException;
import cn.com.chinahitech.market.visual.entity.Pie;
import cn.com.chinahitech.market.visual.entity.Pie1;
import cn.com.chinahitech.market.visual.entity.Pie2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IPieService<T> extends IService<T> {

    List<T> getData() throws QueryException;



}

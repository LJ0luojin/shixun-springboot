package edu.fit.service.Impl;

import edu.fit.mapper.ExpressItemMapper;
import edu.fit.pojo.ExpressItem;
import edu.fit.service.IExpressItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressItemServiceImpl implements IExpressItemService {
    @Autowired
    private ExpressItemMapper expressItemMapper;

    @Override
    public int insertOrder(ExpressItem expressItem) {
        return expressItemMapper.insertOrder(expressItem);
    }

    @Override
    public ExpressItem selectEIMessage(String eiNumber) {
        return expressItemMapper.selectEIMessage(eiNumber);
    }
}

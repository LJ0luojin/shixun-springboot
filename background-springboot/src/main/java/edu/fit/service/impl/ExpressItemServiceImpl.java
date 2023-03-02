package edu.fit.service.impl;

import edu.fit.mapper.ExpressItemMapper;
import edu.fit.pojo.ExpressItem;
import edu.fit.service.IExpressItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressItemServiceImpl implements IExpressItemService {
    @Autowired
    private ExpressItemMapper expressItemMapper;

    @Override
    public List<ExpressItem> selectAllEi() {
        return expressItemMapper.selectAllEi();
    }

    @Override
    public List<ExpressItem> selectForCourier(Integer courierId) {
        return expressItemMapper.selectForCourier(courierId);
    }

    @Override
    public List<ExpressItem> selectAllByEiState(Integer eiState) {
        return expressItemMapper.selectAllByEiState(eiState);
    }

    @Override
    public int updataEiState(ExpressItem expressItem) {
        return expressItemMapper.updataEiState(expressItem);
    }

    @Override
    public List<ExpressItem> selectAllByEiStateForCourier(ExpressItem expressItem) {
        return expressItemMapper.selectAllByEiStateForCourier(expressItem);
    }
}

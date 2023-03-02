package edu.fit.service;

import edu.fit.pojo.ExpressItem;

import java.util.List;

public interface IExpressItemService {

    List<ExpressItem> selectAllEi();
    List<ExpressItem> selectForCourier(Integer courierId);
    List<ExpressItem> selectAllByEiState(Integer eiState);
    int updataEiState(ExpressItem expressItem);
    List<ExpressItem> selectAllByEiStateForCourier(ExpressItem expressItem);
}

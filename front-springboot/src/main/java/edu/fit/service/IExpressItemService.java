package edu.fit.service;

import edu.fit.pojo.ExpressItem;

public interface IExpressItemService {

    int insertOrder(ExpressItem expressItem);

    ExpressItem selectEIMessage(String eiNumber);
}

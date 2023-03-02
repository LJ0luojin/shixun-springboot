package edu.fit.mapper;

import edu.fit.pojo.ExpressItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpressItemMapper {
    int insertOrder(ExpressItem expressItem);

    ExpressItem selectEIMessage(String eiNumber);
}

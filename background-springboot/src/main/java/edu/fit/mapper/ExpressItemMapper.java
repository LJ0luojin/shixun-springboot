package edu.fit.mapper;

import edu.fit.pojo.ExpressItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpressItemMapper {
    List<ExpressItem> selectAllEi();
    List<ExpressItem> selectForCourier(Integer courierId);

    List<ExpressItem> selectAllByEiState(Integer eiState);

    int updataEiState(ExpressItem expressItem);

    List<ExpressItem> selectAllByEiStateForCourier(ExpressItem expressItem);
}

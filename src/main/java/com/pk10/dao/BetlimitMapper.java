package com.pk10.dao;

import com.pk10.bean.Betlimit;
import com.pk10.bean.BetlimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BetlimitMapper {
    int countByExample(BetlimitExample example);

    int deleteByExample(BetlimitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Betlimit record);

    int insertSelective(Betlimit record);

    List<Betlimit> selectByExample(BetlimitExample example);

    Betlimit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Betlimit record, @Param("example") BetlimitExample example);

    int updateByExample(@Param("record") Betlimit record, @Param("example") BetlimitExample example);

    int updateByPrimaryKeySelective(Betlimit record);

    int updateByPrimaryKey(Betlimit record);
}
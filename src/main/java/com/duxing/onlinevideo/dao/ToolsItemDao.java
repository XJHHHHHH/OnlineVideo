package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.ToolsItem;

import java.util.HashMap;
import java.util.List;

public interface ToolsItemDao {


    int insertToolsItem(ToolsItem toolsItem);

    List<ToolsItem> findToolsItemByCondition(HashMap<String,Object> hashMap);

    List<ToolsItem> findToolsItemAll();
}

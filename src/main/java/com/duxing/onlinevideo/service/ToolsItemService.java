package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.ToolsItem;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;

public interface ToolsItemService {
    int insertToolsItem(ToolsItem toolsItem);

    PageInfo<ToolsItem>  getToolsItemPage(int toolTypeId);
    PageInfo<ToolsItem>  getToolsItemAll();
}

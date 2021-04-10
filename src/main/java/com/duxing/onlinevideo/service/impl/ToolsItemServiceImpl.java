package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.ToolsItemDao;
import com.duxing.onlinevideo.entity.ToolsItem;
import com.duxing.onlinevideo.service.ToolsItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ToolsItemServiceImpl implements ToolsItemService {

    @Autowired
    ToolsItemDao toolsItemDao;

    @Override
    public int insertToolsItem(ToolsItem toolsItem) {
        return toolsItemDao.insertToolsItem(toolsItem);
    }

    @Override
    public PageInfo<ToolsItem> getToolsItemPage(int toolTypeId) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("toolTypeId",toolTypeId);
        List<ToolsItem> list = toolsItemDao.findToolsItemByCondition(hashMap);
        PageInfo<ToolsItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ToolsItem> getToolsItemAll() {
        List<ToolsItem> list = toolsItemDao.findToolsItemAll();
        PageInfo<ToolsItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}

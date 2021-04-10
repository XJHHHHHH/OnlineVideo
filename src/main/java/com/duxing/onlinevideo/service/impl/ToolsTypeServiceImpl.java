package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.ToolsTypeDao;
import com.duxing.onlinevideo.entity.ToolsType;
import com.duxing.onlinevideo.service.ToolsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsTypeServiceImpl implements ToolsTypeService {

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Override
    public int insertToolsType(ToolsType toolsType) {
        return toolsTypeDao.insertToolsType(toolsType);
    }

    @Override
    public List<ToolsType> findToolsTypeAll() {
        return toolsTypeDao.findToolsTypeAll();
    }
}

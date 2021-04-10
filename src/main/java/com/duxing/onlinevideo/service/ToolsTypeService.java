package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.ToolsType;

import java.util.List;

public interface ToolsTypeService {
    int insertToolsType(ToolsType toolsType);

    List<ToolsType> findToolsTypeAll();
}

package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.ToolsType;

import java.util.List;

public interface ToolsTypeDao {

    int insertToolsType(ToolsType toolsType);

    List<ToolsType> findToolsTypeAll();
}

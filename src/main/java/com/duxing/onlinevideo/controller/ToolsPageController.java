package com.duxing.onlinevideo.controller;

import com.duxing.onlinevideo.entity.ToolsItem;
import com.duxing.onlinevideo.entity.ToolsType;
import com.duxing.onlinevideo.service.ToolsItemService;
import com.duxing.onlinevideo.service.ToolsTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ToolsPageController {

    @Autowired
    ToolsItemService toolsItemService;

    @Autowired
    ToolsTypeService toolsTypeService;

    //工具
    @RequestMapping(value = "/tools/type/{toolTypeId}")
    public String toolsPage(@PathVariable Integer toolTypeId, Model model, Integer pageNum) {
        model.addAttribute("navFocus",5);
        if(pageNum==null || pageNum<=1){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,16);
        PageInfo<ToolsItem> pageInfo=null;
        if(toolTypeId==0){
            //如果type==0，就返回全部数据
            pageInfo = toolsItemService.getToolsItemAll();
        }else {
            //否则根据对应type查找返回
            pageInfo =  toolsItemService.getToolsItemPage(toolTypeId);
        }
        List<ToolsType> list = toolsTypeService.findToolsTypeAll();

        model.addAttribute("toolList",pageInfo);
        model.addAttribute("toolTypeList",list);
        model.addAttribute("toolTypeId",toolTypeId);
        return "tools";
    }
}

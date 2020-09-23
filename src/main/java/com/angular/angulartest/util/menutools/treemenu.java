package com.angular.angulartest.util.menutools;

import com.angular.angulartest.dao.entity.ChildrenMenu;
import com.angular.angulartest.dao.entity.Menu;
import com.angular.angulartest.dao.entity.TreeMenu;
import com.angular.angulartest.dao.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class treemenu {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    public List<TreeMenu> menuuitl(){

        List<TreeMenu> listtreeMenu = new LinkedList<>();
        List<Menu> listmenu = menuServiceImpl.list();
        for(Menu m : listmenu){
            TreeMenu treeMenu = new TreeMenu();
            if(m.getParentMenuId()==null){
                treeMenu.setName(m.getMenuName());
                List<ChildrenMenu> childrenmenu = new LinkedList<>();
                String menuId = m.getMenuId();
                for(Menu cm : listmenu){
                    if(menuId.equals(cm.getParentMenuId())){
                        ChildrenMenu childrenMenu = new ChildrenMenu();
                        childrenMenu.setName(cm.getMenuName());
                        //childrenMenu.setUrl(cm.getMenuUrl());
                        childrenmenu.add(childrenMenu);
                        treeMenu.setChildrenmenu(childrenmenu);
                    }
                }
                listtreeMenu.add(treeMenu);
            }
        }
        return listtreeMenu;
    }
}

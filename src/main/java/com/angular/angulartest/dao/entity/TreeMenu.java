package com.angular.angulartest.dao.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TreeMenu {

    private String name;
    private List<ChildrenMenu> childrenmenu;
}

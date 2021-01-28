/*
 * Copyright (c) 2020. Shanghai TongYan Civil Engineering Technology Corp., Ltd. All rights reserved.
 */
package Java_Basic.listtotree;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 一句话描述此类
 *
 * @author 钟鸣
 * @Date 2020/9/1 13:28
 */
public class ToModel {
    private static void forEach(Map<String, List<TreeMenuNode>> collect, TreeMenuNode treeMenuNode) {
        List<TreeMenuNode> treeMenuNodes = collect.get(treeMenuNode.getId());
        if(!CollectionUtils.isEmpty(treeMenuNodes)){
            //排序
            List<TreeMenuNode> list=treeMenuNodes.stream()
                    .sorted(Comparator.comparing(TreeMenuNode::getSort))
                    .peek(t-> forEach(collect,t))
                    .collect(Collectors.toList());
            treeMenuNode.setChildren(list);
        }
    }

    public static void main(String[] args) {
        List<TreeMenuNode> treeNodeList = new ArrayList<>();
        //分组
        Map<String, List<TreeMenuNode>> collect = treeNodeList.stream().collect(Collectors.groupingBy(TreeMenuNode::getParentId));
        //树形结构 肯定有一个根部，我的这个根部的就是parentId.euqal("0"),而且只有一个就get（"0"）
        TreeMenuNode treeMenuNode = collect.get("0").get(0);
        //拼接数据
        forEach(collect, treeMenuNode);
    }
}

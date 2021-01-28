package Java_Basic.listtotree;

import java.util.List;
import java.util.Map;

public class TreeMenuNode {
    private String id;
    private String parentId;
    private String name;
    private Integer sort;
    private List<TreeMenuNode> children;
    private Boolean isAble;

    /**20180929zhw添加 树的额外属性(至少含有父节点ID:"parentId")**/
    private Map<String,Object> attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<TreeMenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenuNode> children) {
        this.children = children;
    }

    public Boolean getAble() {
        return isAble;
    }

    public void setAble(Boolean able) {
        isAble = able;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}

package com.storage.entity.vo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PermissionVo {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String name;
    private String path;
    private Long pid;
    private List<PermissionVo> children;
    public static List<PermissionVo> buildTree(List<PermissionVo> list){
        List<PermissionVo> tree=new ArrayList<>();
        List<PermissionVo> child=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPid()==0){
                tree.add(list.get(i));
            }else {
                child.add(list.get(i));
            }
        }
        for(PermissionVo p : tree){
            List<PermissionVo> cList = new ArrayList<>();
            for(PermissionVo c : child){
                if(c.getPid()-p.getId()==0){
                    cList.add(c);
                }
            }
            p.setChildren(cList);
        }
        return tree;
    }

    public static void build(PermissionVo parent , List<PermissionVo> list){
        List<PermissionVo> child = list.stream().filter(c-> c.getPid()-parent.getId()==0).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(child)) return;
        parent.setChildren(child);
        child.forEach(c->build(c,list));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<PermissionVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVo> children) {
        this.children = children;
    }
}

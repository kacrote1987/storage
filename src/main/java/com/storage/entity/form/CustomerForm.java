package com.storage.entity.form;

import javax.validation.constraints.NotNull;

public class CustomerForm {
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "身份证号码不能为空")
    private Long idCard;
    @NotNull(message = "电话号码不能为空")
    private Long tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }
}

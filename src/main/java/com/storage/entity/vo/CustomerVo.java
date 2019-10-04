package com.storage.entity.vo;

public class CustomerVo {
    private Long id;
    private String name;
    private Long idCard;
    private Long tel;
    private Long vipCard;
    private Long score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getVipCard() {
        return vipCard;
    }

    public void setVipCard(Long vipCard) {
        this.vipCard = vipCard;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}

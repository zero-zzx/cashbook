package com.zzx.cashbook.beans;

public class AccountBean {
    int id;
    String typename;
    int sImageId,kind;
    float money;
    String note,time;

    public AccountBean(int id, String typename, int sImageId, int kind, float money, String note, String time) {
        this.id = id;
        this.typename = typename;
        this.sImageId = sImageId;
        this.kind = kind;
        this.money = money;
        this.note = note;
        this.time = time;
    }

    public AccountBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typename;
    }

    public void setTypeName(String typeName) {
        this.typename = typeName;
    }

    public int getsImageId() {
        return sImageId;
    }

    public void setsImageId(int sImageId) {
        this.sImageId = sImageId;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

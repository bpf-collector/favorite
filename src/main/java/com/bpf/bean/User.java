package com.bpf.bean;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @DynamicInsert: 当插入的时候会自动过滤null的字段
 */
@DynamicInsert
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String password;
    @Column(columnDefinition = "char(8) default 'v39a470m'")
    private String salt;

    private LocalDateTime createTime;

    // 1-普通用户 2-管理员
    @Column(columnDefinition = "tinyint default 1")
    private Byte authority;

    @Column(columnDefinition = "smallint default 0")
    private Short markCount;

    @Column(columnDefinition = "smallint default 0")
    private Short linkCount;

    // 设置 当删除用户时，用户的标签数据也删除
    // 查询时，n的一端设置为懒加载
    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Mark> marks = new HashSet<>();

    // 设置 当删除用户时，用户的链接数据也删除
    // 查询时，n的一端设置为懒加载
    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Link> linkList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Byte getAuthority() {
        return authority;
    }

    public void setAuthority(Byte authority) {
        this.authority = authority;
    }

    public Short getMarkCount() {
        return markCount;
    }

    public void setMarkCount(Short markCount) {
        this.markCount = markCount;
    }

    public Short getLinkCount() {
        return linkCount;
    }

    public void setLinkCount(Short linkCount) {
        this.linkCount = linkCount;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                ", authority=" + authority +
                ", markCount=" + markCount +
                ", linkCount=" + linkCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(authority, user.authority) &&
                Objects.equals(markCount, user.markCount) &&
                Objects.equals(linkCount, user.linkCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, salt, createTime, authority, markCount, linkCount);
    }
}

package com.bpf.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@DynamicInsert
@Entity
@Table(name = "t_link")
public class Link implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(32)")
    private String name;
    @Column(columnDefinition = "varchar(64)")
    private String url;
    private LocalDateTime createTime;
    @Column(columnDefinition = "varchar(255)")
    private String comment;
    @Column(columnDefinition = "text")
    private String icon;

    @ManyToMany(mappedBy = "linkList")
    @JsonIgnoreProperties(value = {"linkList", "hibernateLazyInitializer", "handler"})
    private Set<Mark> marks = new HashSet<>();

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", comment='" + comment + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id) &&
                Objects.equals(name, link.name) &&
                Objects.equals(url, link.url) &&
                Objects.equals(createTime, link.createTime) &&
                Objects.equals(comment, link.comment) &&
                Objects.equals(icon, link.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, createTime, comment, icon);
    }
}

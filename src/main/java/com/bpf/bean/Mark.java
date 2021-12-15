package com.bpf.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_mark")
public class Mark implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(32)")
    private String name;

    // 指定中间表 mark_link
    @JoinTable(name = "t_mark_link",
        joinColumns = {@JoinColumn(name = "mark_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "link_id", referencedColumnName = "id")})
    @ManyToMany
    @JsonIgnoreProperties(value = {"marks", "hibernateLazyInitializer", "handler"})
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

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(id, mark.id) &&
                Objects.equals(name, mark.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

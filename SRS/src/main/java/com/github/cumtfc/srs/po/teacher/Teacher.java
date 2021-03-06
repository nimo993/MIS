package com.github.cumtfc.srs.po.teacher;

import com.github.cumtfc.srs.po.arrange.CourseArrange;
import com.github.cumtfc.srs.po.user.SysUser;

import javax.persistence.*;
import java.util.List;

/**
 * @author 冯楚
 * @date 2018/6/8-19:12
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"teacherSn"}))
public class Teacher {

    private Integer id;

    private String teacherSn;

    private String title;

    private String department;

    private String name;

    private List<CourseArrange> courseArranges;

    private SysUser user;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherSn() {
        return teacherSn;
    }

    public void setTeacherSn(String teacherSn) {
        this.teacherSn = teacherSn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "teacher")
    public List<CourseArrange> getCourseArranges() {
        return courseArranges;
    }

    public void setCourseArranges(List<CourseArrange> courseArranges) {
        this.courseArranges = courseArranges;
    }

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}

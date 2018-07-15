package com.patience.entity;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 公司CEO
 * @author Administrator
 *
 */
@Entity
@Table(name="t_ceo")
public class CEO implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length=64)
    private String name;
    /**
     * 简介
     */
    private String description;
    /**
     * 家乡
     */
    private String homeTown;
    /**
     * 所上学校，从大学开始
     */
    private String university;
    /**
     * 研究生学校
     */
    private String postGraduate;
    /**
     * 博士学校
     */
    private String doctorSchool;
    /**
     * 学历
     */
    private String education;
    /**
     * 所属公司
     */
    @OneToOne(mappedBy="ceo")
    private Company company;
    
    @Column(length=4)
    private int age;
    
    @Column(length=2)
    private String sex;
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
 
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPostGraduate() {
		return postGraduate;
	}

	public void setPostGraduate(String postGraduate) {
		this.postGraduate = postGraduate;
	}

	public String getDoctorSchool() {
		return doctorSchool;
	}

	public void setDoctorSchool(String doctorSchool) {
		this.doctorSchool = doctorSchool;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "CEO [id=" + id + ", name=" + name + ", description=" + description + ", homeTown=" + homeTown
				+ ", university=" + university + ", postGraduate=" + postGraduate + ", doctorSchool=" + doctorSchool
				+ ", education=" + education + ", company=" + company + ", age=" + age + ", sex=" + sex + "]";
	}

}

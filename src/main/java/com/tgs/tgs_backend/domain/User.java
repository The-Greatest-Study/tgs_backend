package com.tgs.tgs_backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NM")
    private String userNm;

    @Column(name = "PW")
    private String pw;

    @Column(name = "USER_BDAY")
    private Date userBday;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ACTIVE_YN")
    private String activeYn;

    @Column(name = "ADMIN_YN")
    private String adminYn;

    @Column(name = "USE_YN")
    private String useYn;

}

package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    // db의 컬럼명이 username이면 이렇게 맵핑시킬 수 있다.
//    @Column(name="username")
    private String name;

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
}   // end class

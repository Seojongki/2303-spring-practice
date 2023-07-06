package com.tj.edu.practice3.spring_exception.dto;


import jakarta.validation.constraints.*;

public class User {
    //@NotNull(message = "이름은 필수 입력입니다.")
    //@Size(min=2, max=4, message = "이름은 2자에서 4자사이로만 작성 가능합니다.")
    @NotBlank()
    private String name;

    @Max(130)
    @Min(1)
    private int age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

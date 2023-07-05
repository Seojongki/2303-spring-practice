package com.tj.edu.practice2.validation.model.dto;

import com.tj.edu.practice2.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;

public class User {
    //@NotNull(message = "이름은 필수 입력입니다.")
    //@Size(min=2, max=4, message = "이름은 2자에서 4자사이로만 작성 가능합니다.")
    @NotBlank()
    private String name;

    @Max(130)
    @Min(1)
    private int age;

    @Email(message = "올바른 이메일 형식이 아닙니다.")
        private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "폰 번호 오류")
    private String phoneNumber;


    @AssertTrue(message = "이메일은 .com으로 끝나야 합니다.")
    public boolean isTestSuccess(){
        if(email.endsWith(".com"))
            return true;

        return false;
    }

//    @AssertFalse(message = "이메일은 .com은 제외합니다.")
//    public boolean isTestFail(){
//        if(email.endsWith(".com"))
//            return true;
//
//        return false;
//    }

    //생년월일
//    @Size(min=8, max=8)
    //형식이 'YYYYMM'  -> 2023
    //@YearMonth(patten = "yyMM")
    @YearMonth(message = "YYYYMM 형식(숫자 6자리)에 맞지 않습니다.")
    private String birth;  //YYYYMM




    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}

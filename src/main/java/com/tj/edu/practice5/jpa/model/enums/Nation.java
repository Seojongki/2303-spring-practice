package com.tj.edu.practice5.jpa.model.enums;

//public enum Nation {
//    KOREA,          //0
//    CHINA,          //1
//    AMERICA,        //2
//    ENGLAND,        //3
//    기타            //4
//}

public enum Nation {
    기타(10),
    CHINA(30),
    KOREA(5),
    ENGLAND(6),
    AMARICA(8);

    private final int value;
    Nation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}




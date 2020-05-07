package com.mock.entities;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Data {
    String id;
    String employee_name;
    String employee_salary;
    String employee_age;
    String profile_image;

    public Data(String id, String employee_name, String employee_salary, String employee_age, String profile_image){
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }
}

package com.finplatforms.test.dbtasktest.db.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class StudentDTO {

    private int id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String middleName;

    @NonNull
    private Date birthday;

    @NonNull
    private String groupName;

    public boolean validateLength() {
        return firstName.length() <= 255 && middleName.length() <= 255 && lastName.length() <= 255 && groupName.length() <= 255;
    }
}

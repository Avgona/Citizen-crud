package com.avgona.citizencrud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "ambassadors")
@NoArgsConstructor
public class Ambassador {

    @Id
    private String id;

    @Field(name = "First_name")
    private String firstName;

    @Field(name = "Last_name")
    private String lastName;

    @Field(name = "Country")
    private String country;

    @Field(name = "Embassy_number")
    private int embassyNumber;

    public Ambassador(String firstName, String lastName, String country, int embassyNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.embassyNumber = embassyNumber;
    }
}

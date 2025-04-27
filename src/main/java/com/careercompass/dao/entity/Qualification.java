package com.careercompass.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.careercompass.constants.CareerCompassConstants.QUALIFICATION_COLLECTION;

@Data
@Document(collection = QUALIFICATION_COLLECTION)
public class Qualification {
    @Id
    private String id;
    private String stream;
    private String name;
    private String icon;
    private List<String> options;
    private String color;

}

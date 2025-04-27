package com.careercompass.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

import static com.careercompass.constants.CareerCompassConstants.JOB_COLLECTION;

@Data
@Document(collection = JOB_COLLECTION)
public class Job implements Serializable {
    @Id
    private String id;
    private String title;
    private List<String> tags;
    private List<String> tagColors;
    private String description;
    private String fullDescription;
    private String rate;
    private String posted;
    private String logo;
    private String sector;
    private String qualification;
    private List<String> skills;
    private Integer age;
}

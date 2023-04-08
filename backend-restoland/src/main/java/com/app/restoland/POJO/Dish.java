package com.app.restoland.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer qualification;
    private String status;
    @Column(name = "heal_score")
    private Integer healtScore;
    @Column(name = "preparation_time")
    private String preparationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", nullable = false)
    private Category category;
}

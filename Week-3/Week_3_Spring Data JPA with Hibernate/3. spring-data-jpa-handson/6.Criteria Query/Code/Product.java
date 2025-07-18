package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "ram_size")
    private int ramSize; 

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "hard_disk_size")
    private int hardDiskSize; 
    @Column(name = "os")
    private String os;

    private double weight;

    @Column(name = "customer_review")
    private double customerReview; 
    @Column(name = "cpu_speed")
    private double cpuSpeed; 

    


    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", ramSize=" + ramSize + ", cpu=" + cpu +
               ", hardDiskSize=" + hardDiskSize + ", os=" + os + ", weight=" + weight +
               ", customerReview=" + customerReview + ", cpuSpeed=" + cpuSpeed + "]";
    }
}

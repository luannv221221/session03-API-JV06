package com.ra.session03.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name",length = 100,nullable = false,unique = true)
    private String categoryName;
    @Column(name = "category_status")
    private Boolean categoryStatus;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}

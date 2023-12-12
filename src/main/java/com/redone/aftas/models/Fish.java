package com.redone.aftas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double averageWeight;
    @OneToMany(mappedBy = "fish")
    private List<Hunting> huntingList;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
}

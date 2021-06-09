package com.example.beadando.manufacturer;

import javax.persistence.*;
@Table(name = "manufacturer")
@Entity
public class ManufacturerEntity {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column(name = "name")
    private  String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public ManufacturerEntity() {
    }

    public ManufacturerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

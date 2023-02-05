package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Odul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String odulAdi;




    public Odul(String odulAdi) {
        this.odulAdi = odulAdi;
    }
}

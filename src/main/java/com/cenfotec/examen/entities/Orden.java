package com.cenfotec.examen.entities;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cantProducto;
    private long costo;
    private String tipoProducto;
    private String imagen;
    private long cliente;
}

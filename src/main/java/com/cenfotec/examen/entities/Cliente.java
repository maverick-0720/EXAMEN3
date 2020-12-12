package com.cenfotec.examen.entities;
import java.io.Serializable;
import java.util.List;
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
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroTarjeta;
    private long mesTarjeta;
    private long annoTarjeta;
    private String nombre;
    private String apellido;
    private String direccion;
}

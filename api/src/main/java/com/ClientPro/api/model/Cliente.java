package com.ClientPro.api.model;

import com.ClientPro.api.model.enums.EnumPessoaFisicaJuridica;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long DataNascimento;
    private String endereco;
    private String telefone;
    private String CpfCnpj;
    private EnumPessoaFisicaJuridica FisicaJuridica;
}

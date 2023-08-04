package com.ClientPro.api.model;

import com.ClientPro.api.model.enums.EnumPessoaFisicaJuridica;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String nome;
    @NotEmpty
    @Email
    private String email;
    private Long dataNascimento;
    private String endereco;

    private String telefone;
    private String cpfCnpj;
    private EnumPessoaFisicaJuridica fisicaJuridica;
}

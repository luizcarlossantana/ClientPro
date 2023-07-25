package com.ClientPro.api.model.dtos;

import com.ClientPro.api.model.enums.EnumPessoaFisicaJuridica;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;
    private Long DataNascimento;
    private String endereco;

    private String telefone;
    private String CpfCnpj;
    private EnumPessoaFisicaJuridica FisicaJuridica;
}

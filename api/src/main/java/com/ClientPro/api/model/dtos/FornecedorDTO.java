package com.ClientPro.api.model.dtos;

import lombok.Data;

@Data
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
}

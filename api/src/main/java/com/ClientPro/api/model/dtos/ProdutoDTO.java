package com.ClientPro.api.model.dtos;

import com.ClientPro.api.model.Fornecedor;
import com.ClientPro.api.model.enums.EnumCategorias;
import lombok.Data;

import java.util.List;
@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String codigoDeBarras;
    private String descricao;
    private List<EnumCategorias> categorias;
    private double preco;
    private Fornecedor fornecedor;
}

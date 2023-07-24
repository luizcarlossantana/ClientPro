package com.ClientPro.api.model;

import com.ClientPro.api.model.enums.EnumCategorias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String codigoDeBarras;
        private String descricao;
        private List<EnumCategorias> categorias;
        private double preco;
        @ManyToOne
        @JoinColumn(name = "fornecedor_id")
        private Fornecedor fornecedor;



}

package com.ClientPro.api.model;

import com.ClientPro.api.model.enums.EnumCategorias;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
        // private Fornecedor fornecedor;

}

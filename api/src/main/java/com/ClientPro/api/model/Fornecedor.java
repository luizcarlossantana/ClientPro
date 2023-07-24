package com.ClientPro.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    @OneToMany // se colocar ManyToOne da erro pq? a leitura é: um fornecedor para muitos peodutos nesse caso OneToMany? ?
    @JoinColumn(name = "produto_id")// esse atributos produtos não deixaria menso performatico minha aplicação?
    private List<Produto> produto;
}

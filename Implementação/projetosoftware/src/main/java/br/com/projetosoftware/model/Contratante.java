package br.com.projetosoftware.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contratantes")
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

    private String login;
    private String senha;
    private String nome;
    private Long automovel_id;
    private Long RG;
    private Long CPF;
    private String endereco;
    private String profissao;
    private String entidade_empregadoras;
    private double rendimentos;
}

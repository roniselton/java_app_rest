package com.example.apprestbasic.entity;

import com.example.apprestbasic.enumerados.TipoPessoa;
import javax.persistence.*;

import com.example.apprestbasic.enumerados.TipoRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_usuario" , schema = "public")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(generator = "seq_usuario" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_usuario" , sequenceName = "seq_usuario",  schema = "public" ,initialValue = 1 , allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "tipo_pessoa")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "role_usuario")
    @Enumerated(EnumType.STRING)
    private TipoRole role;


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoPessoa=" + tipoPessoa +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                '}';
    }
}

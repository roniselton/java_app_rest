package com.example.apprestbasic.enumerados;

import lombok.Getter;

@Getter
public enum TipoPessoa {
    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private final String descricao;

    TipoPessoa(String s) {
        descricao = s;
    }

}

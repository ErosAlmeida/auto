package com.br.auto.Pessoa;

public class Pessoa {
    String nome;
    int numfigurinhas;

    void receber(int numfigurinhas){

        this.numfigurinhas += numfigurinhas;
    }

    void dar(int numfigurinhas, Pessoa p){
        this.numfigurinhas -= numfigurinhas;
        p.numfigurinhas += numfigurinhas;
    }
}

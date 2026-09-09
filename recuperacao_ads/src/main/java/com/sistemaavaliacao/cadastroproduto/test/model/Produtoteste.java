package com.sistemaavaliacao.cadastroproduto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// testes da classe Produto
// cada categoria é uma particao de equivalencia diferente (regra do README)
class ProdutoTest {

    @Test
    void deveCalcularPercentualAlimento() {
        Produto produto = new Produto("Arroz", 100, 1, "Alimento");
        assertEquals(15, produto.calcularPercentualLucro());
    }

    @Test
    void deveCalcularPercentualEletrico() {
        Produto produto = new Produto("Ventilador", 100, 1, "Elétrico");
        assertEquals(25, produto.calcularPercentualLucro());
    }

    @Test
    void deveCalcularPercentualAutomotivo() {
        Produto produto = new Produto("Pneu", 100, 1, "Automotivo");
        assertEquals(30, produto.calcularPercentualLucro());
    }

    @Test
    void deveCalcularPercentualLimpeza() {
        Produto produto = new Produto("Detergente", 100, 1, "Limpeza");
        assertEquals(20, produto.calcularPercentualLucro());
    }

    // qualquer categoria fora da lista cai na partição "Outros"
    @Test
    void deveCalcularPercentualCategoriaDesconhecida() {
        Produto produto = new Produto("Livro", 100, 1, "Outros");
        assertEquals(10, produto.calcularPercentualLucro());
    }

    @Test
    void deveCalcularPrecoVenda() {
        Produto produto = new Produto("Arroz", 100, 1, "Alimento");
        assertEquals(115, produto.calcularPrecoVenda());
    }

    @Test
    void deveCalcularPrecoVendaAutomotivo() {
        Produto produto = new Produto("Pneu", 100, 1, "Automotivo");
        assertEquals(130, produto.calcularPrecoVenda());
    }

    @Test
    void deveCalcularValorTotal() {
        Produto produto = new Produto("Arroz", 100, 3, "Alimento");
        // preco venda 115 x 3 unidades
        assertEquals(345, produto.calcularValorTotal());
    }

    // caso de borda: quantidade zero
    @Test
    void deveCalcularValorTotalComQuantidadeZero() {
        Produto produto = new Produto("Arroz", 100, 0, "Alimento");
        assertEquals(0, produto.calcularValorTotal());
    }

    @Test
    void deveRetornarDadosDoProduto() {
        Produto produto = new Produto("Arroz", 100, 3, "Alimento");
        assertEquals("Arroz", produto.getNome());
        assertEquals(100, produto.getPrecoCusto());
        assertEquals(3, produto.getQuantidade());
        assertEquals("Alimento", produto.getCategoria());
    }
}
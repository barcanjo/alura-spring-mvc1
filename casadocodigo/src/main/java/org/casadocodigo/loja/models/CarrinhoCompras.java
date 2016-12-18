package org.casadocodigo.loja.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o carrinho de compras da loja
 * @author Bruno Arcanjo
 *
 */
@Component
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
    
    /**
	 * Adiciona um item ao carrinho de compras e adicionando a quantidade desse item no carrinho
	 * @param item O item que será adicionado ao carrinho
	 */
    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }
    
    /**
	 * Retorna a quantidade do item no carrinho de compras
	 * @param item O item que se quer obter a quantidade existente no carrinho de compras
	 * @return A quantidade do item
	 */
    private int getQuantidade(CarrinhoItem item) {
        if (!itens.containsKey(item)) {
            itens.put(item, 0);
        }
        return itens.get(item);
    }

    public int getQuantidade() {
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

}
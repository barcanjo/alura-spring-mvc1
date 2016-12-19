package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDAO;
import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.CarrinhoItem;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/adicionar")
    public ModelAndView adicionar(Integer produtoId, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = produtoDAO.find(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
        return carrinhoItem;
    }

}
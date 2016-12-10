package org.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe DAO responsável pelos acessos a dados da entidade Produto
 * @author Bruno Arcanjo
 *
 */

@Repository // diz que a classe acessará dados (nesse caso do banco de dados)
@Transactional // informa que os métodos da classe utilizarão transações
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {
		manager.persist(produto);		
	}
}

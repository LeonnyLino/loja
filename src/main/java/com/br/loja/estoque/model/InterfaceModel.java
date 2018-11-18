package com.br.loja.estoque.model;

import java.io.Serializable;

public interface InterfaceModel<ID> extends Serializable {
	ID getId();
	
	void setId(ID id);

}

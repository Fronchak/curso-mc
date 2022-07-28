package com.nelioalves.cursomc.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nelioalves.cursomc.entities.enums.TipoCliente;

@Entity
@Table(name="tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	
	@OneToMany(mappedBy="cliente")
	private List<Telefone> telefones = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	public Cliente() {}

	public Cliente(Integer id, String name, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		setTipo(tipo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public TipoCliente getTipo() {
		return TipoCliente.valueOf(tipo);
	}

	public void setTipo(TipoCliente tipoCliente) {
		if(tipoCliente != null) {
			this.tipo = tipoCliente.getCodigo();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	};
}

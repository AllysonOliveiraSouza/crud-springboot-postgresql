package com.projetoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoapi.dto.UsuarioDTO;
import com.projetoapi.entities.UsuarioEntity;
import com.projetoapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> listarTodos(){
		List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();		
		return listaUsuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);		
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioEntity);
	}
	
	public UsuarioDTO buscarPorID(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());		
	}
	
}

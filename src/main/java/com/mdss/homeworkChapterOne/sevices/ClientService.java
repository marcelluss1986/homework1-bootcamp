package com.mdss.homeworkChapterOne.sevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdss.homeworkChapterOne.dto.ClientDTO;
import com.mdss.homeworkChapterOne.entities.Client;
import com.mdss.homeworkChapterOne.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(PageRequest page){
		Page<Client> list = repository.findAll(page);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(()-> new RuntimeException("Entity not found!"));
		return new ClientDTO(entity);
	}
	
	public ClientDTO inset(ClientDTO dto) {
		Client entity = new Client();
		insertNewClient(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	private void insertNewClient(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setIncome(dto.getIncome());
		entity.setChildren(dto.getChildren());
	}
}

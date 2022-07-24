package com.mdss.homeworkChapterOne.sevices;

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
}

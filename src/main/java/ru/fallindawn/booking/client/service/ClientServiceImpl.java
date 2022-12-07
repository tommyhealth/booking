package ru.fallindawn.booking.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.client.domain.Client;
import ru.fallindawn.booking.client.dto.ClientDto;
import ru.fallindawn.booking.client.mapper.ClientMapper;
import ru.fallindawn.booking.client.repository.ClientRepository;

import javax.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = clientRepository.save(clientMapper.toEntity(clientDto));
        return clientMapper.toDto(client);

    }
}

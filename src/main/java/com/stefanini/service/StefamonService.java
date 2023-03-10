package com.stefanini.service;

import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
@ApplicationScoped
public class StefamonService {

    @Inject
    StefamonRepository repository;

    public List<Stefamon> listarTodos(){
        return repository.listAll();
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return stefamon;
    }

 }

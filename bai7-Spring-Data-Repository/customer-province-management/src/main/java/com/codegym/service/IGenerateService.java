package com.codegym.service;

import com.codegym.exception.DuplicateEmailException;
import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface IGenerateService<T>{

    Iterable<T> findAll();

    void save(T t) throws DuplicateEmailException;

    Optional<T> findById(Long id);

    void remove(Long id);
}

package br.com.developeracademy.citiescatalog.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    public List<CountryDTO> findAll(){
        List<Country> list = repository.findAll();
        List<CountryDTO> listDTOs = list.stream().map(x -> new CountryDTO(x)).collect(Collectors.toList());
        return listDTOs;
    }
}

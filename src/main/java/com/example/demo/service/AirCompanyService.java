package com.example.demo.service;

import com.example.demo.dao.AirCompanyRepository;
import com.example.demo.dao.BadRequestException;
import com.example.demo.dto.AirCompanyCreateDto;
import com.example.demo.entity.AirCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyService implements IAirCompanyService {

    AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirCompanyService(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public List<AirCompany> getAllAirCompanies() {
        return airCompanyRepository.findAll();
    }

    @Override
    public AirCompany createAirCompany(AirCompanyCreateDto airCompanyCreateDto) {

        AirCompany airCompany = new AirCompany();
        airCompany.setName(airCompanyCreateDto.getName());
        airCompany.setCompany_type(airCompanyCreateDto.getCompany_type());
        airCompany.setFounded_at(airCompanyCreateDto.getFounded_at());

        return airCompanyRepository.saveAndFlush(airCompany);
    }

    @Override
    public AirCompany updateAirCompany(int id, AirCompany airCompany) {

        if (airCompanyRepository.existsById(id)) {
            airCompany.setId(id);
            return airCompanyRepository.saveAndFlush(airCompany);
        } else throw new IllegalArgumentException("No air company with such id found: " + id);
    }

    @Override
    public void deleteCompanyById(int id) {
        airCompanyRepository.deleteById(id);
    }
}

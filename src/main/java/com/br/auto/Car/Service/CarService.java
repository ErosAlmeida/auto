package com.br.auto.Car.Service;

import com.br.auto.Car.Car;
import com.br.auto.Car.Repository.CarRepository;
import com.br.auto.Car.dto.CarDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> listar() {
        return repository.findAll();
    }


    public Car buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Carro não encontrado"
                        )
                );
    }

    public Car criar(CarDto dto) {

        Car carro = new Car();

        carro.setPlaca(dto.getPlaca());
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());

        return repository.save(carro);
    }

    @Transactional
    public Car atualizar(UUID id, CarDto dto) {

        Car car = buscarPorId(id);

        car.setPlaca(dto.getPlaca());
        car.setModelo(dto.getModelo());
        car.setAno(dto.getAno());

        return car;
    }

    public void deletar(UUID id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Carro não encontrado");
        }

        repository.deleteById(id);
    }
}
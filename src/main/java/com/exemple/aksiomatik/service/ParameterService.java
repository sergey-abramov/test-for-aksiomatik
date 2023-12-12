package com.exemple.aksiomatik.service;

import com.exemple.aksiomatik.dto.XDto;
import com.exemple.aksiomatik.model.Parameter;
import com.exemple.aksiomatik.repository.ParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ParameterService {

    private final ParameterRepository repository;

    public Parameter save(Parameter parameter) {
        return repository.save(parameter);
    }

    public XDto solve(Parameter parameter) {
        BigDecimal x1;
        BigDecimal x2;
        int a = parameter.getA();
        int b = parameter.getB();
        int c = parameter.getC();
        double D = (Math.pow(b, 2) - (4 * a * c));

        if (D > 0) {
            x1 = BigDecimal.valueOf((-b - Math.sqrt(D)) / (2 * a));
            x2 = BigDecimal.valueOf((- b + Math.sqrt(D)) / (2 * a));
            parameter.setX1(x1.setScale(4, RoundingMode.DOWN).doubleValue());
            parameter.setX2(x2.setScale(4, RoundingMode.DOWN).doubleValue());
            save(parameter);
            return new XDto(parameter.getX1(), parameter.getX2());
        }
        if (D == 0) {
            x1 = BigDecimal.valueOf(-b / (2 * a));
            parameter.setX1(x1.setScale(4, RoundingMode.DOWN).doubleValue());
            parameter.setX2(x1.setScale(4, RoundingMode.DOWN).doubleValue());
            save(parameter);
            return new XDto(parameter.getX1(), parameter.getX2());
        }
        throw new IllegalArgumentException("Введите другие числа");
    }

    public Optional<Parameter> findById(Parameter parameter) {
        return repository.findById(parameter.getId());
    }

}

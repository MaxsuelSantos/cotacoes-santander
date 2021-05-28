package com.max.cotacoes.service;

import com.max.cotacoes.exceptions.BusinessException;
import com.max.cotacoes.mapper.StockMapper;
import com.max.cotacoes.model.Stock;
import com.max.cotacoes.model.dto.StockDTO;
import com.max.cotacoes.repository.StockRepository;
import com.max.cotacoes.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
}

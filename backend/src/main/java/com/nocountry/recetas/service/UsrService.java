package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.request.UsrRequest;
import com.nocountry.recetas.domain.response.UsrResponse;
import com.nocountry.recetas.persistence.usr.UsrSupplier;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsrService {

    private final UsrSupplier supplier;

    public List<UsrResponse> findAll() {
        return supplier.findAll();
    }

    public UsrResponse findById(Long id) {
        return supplier.findById(id);
    }

    public UsrResponse save(UsrRequest request) {
        return supplier.save(request);
    }

    public void deleteById(Long id) {
        supplier.deleteById(id);
    }

}

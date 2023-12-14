package com.nocountry.recetas.persistence.usr;

import com.nocountry.recetas.domain.request.UsrRequest;
import com.nocountry.recetas.domain.response.UsrResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsrSupplier {

    private final UsrMapper mapper;

    public List<UsrResponse> findAll() {
        return mapper.findAll();
    }

    public UsrResponse findById(Long id) {
        return mapper.findById(id);
    }

    public UsrResponse findByEmail(String email) {
        return mapper.findByEmail(email);
    }

    public UsrResponse save(UsrRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("nombre", request.getNombre());
        body.put("email", request.getEmail());
        body.put("password", request.getPassword());
        mapper.save(body);

        return UsrResponse.builder()
            .nombre((String) body.get("nombre"))
            .email((String) body.get("email"))
            .build();
    }

    public void deleteById(Long id) {
        mapper.deleteById(id);
    }

}

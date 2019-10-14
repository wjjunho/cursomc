package com.nelioalves.cursomc.resource;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteResource {

    private final ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Cliente cliente = clienteService.find(id);

        return ResponseEntity.ok().body(cliente);
    }
}

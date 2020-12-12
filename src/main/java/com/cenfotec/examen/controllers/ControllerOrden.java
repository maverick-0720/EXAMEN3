package com.cenfotec.examen.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.entities.Orden;
import com.cenfotec.examen.repositories.ClienteRepository;
import com.cenfotec.examen.repositories.OrdenRepository;

@RestController
@RequestMapping({ "/grupo-orden" })
public class ControllerOrden {


    private OrdenRepository repository;
    private ClienteRepository clienterepository;

    ControllerOrden(OrdenRepository ordenRepository,ClienteRepository clienteRepository) {
        this.repository = ordenRepository;
        this.clienterepository = clienteRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "orden-id/{id}" })
    public ResponseEntity<Orden> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orden create(@RequestBody Orden orden) {
        orden.setCosto(precio(orden.getTipoProducto(),orden.getCantProducto()));
        return repository.save(orden);
    }

    @GetMapping(path = { "/item/{id}" })
    public List findAll1(@PathVariable String id) {
        List<Orden>lista=repository.findAll();
        for(int i=0;i<lista.size();i++) {
            if(lista.get(i).getTipoProducto().equals(id)) {
            }else {
                lista.remove(lista.get(i));
            }
        }
        return lista;
    }


    @PutMapping(path = { "/cantidad/{id}" })
    public ResponseEntity<Orden> update(@PathVariable("id") long id, @RequestBody Orden orden2) {
        return repository.findById(id).map(record -> {
            record.setCantProducto(orden2.getCantProducto());
            record.setCosto(precio(record.getTipoProducto(),orden2.getCantProducto()));
            Orden updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = { "tipo-orden/{id}" })
    public ResponseEntity<Orden> update2(@PathVariable("id") long id, @RequestBody Orden orden) {
        return repository.findById(id).map(record -> {
            record.setTipoProducto(orden.getTipoProducto());
            record.setCosto(precio(orden.getTipoProducto(),record.getCantProducto()));
            Orden updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public long precio(String tipo,long cantidad) {
        long precio=0;
        switch(tipo)
        {
            case "tasa":
                precio=(int) (cantidad*13);
                break;
            case "vaso":
                precio=(int) (cantidad*15);
                break;
            case "almohadon":
                precio=(int) (cantidad*9);
                break;
            case "camiseta":
                precio=(int) (cantidad*8);
                break;
        }
        return precio;
    }

}

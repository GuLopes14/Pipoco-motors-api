package br.com.fiap.pipoco_motors_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.pipoco_motors_api.model.Listing;
import br.com.fiap.pipoco_motors_api.repository.ListingsRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/listings")

public class ListingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ListingsRepository repository;

    @GetMapping
    public List<Listing> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Listing> create(@Valid @RequestBody Listing listing) {
        log.info("Cadastrando o anúncio " + listing.getModel());
        repository.save(listing);
        return ResponseEntity.status(HttpStatus.CREATED).body(listing);
    }

    @GetMapping("/{id}")
    public Listing get(@PathVariable Long id) {
        log.info("Buscando anúncio " + id);
        return getListing(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Deletando anúncio: " + id);
        repository.delete(getListing(id));
    }

    @PutMapping("/{id}")
    public Listing update(@PathVariable Long id, @RequestBody @Valid Listing listing) {
        log.info("Atualizando anúncio: " + id);

        listing.setId(id);
        return repository.save(listing);
    }

    private Listing getListing(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
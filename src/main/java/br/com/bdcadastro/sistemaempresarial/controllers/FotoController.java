package br.com.bdcadastro.sistemaempresarial.controllers;
import br.com.bdcadastro.sistemaempresarial.dtos.FotoResponseDTO;
import br.com.bdcadastro.sistemaempresarial.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/fotos")


public class FotoController {
    @Autowired //springboot instancia classe
    private FotoService fotoService;
    @GetMapping(value = "/clientes/{id}", produces = "image/png")

    public ResponseEntity<byte[]> recebeFoto(@PathVariable("id") Long id) throws IOException {
        return fotoService.recebeFoto(id);
    }
    @PostMapping("/clientes/{id}")
    public ResponseEntity<FotoResponseDTO> carregaFoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file ) throws IOException {
        return fotoService.armazenaFoto(id,file);
    }

}


package br.com.bdcadastro.sistemaempresarial.controllers;
import br.com.bdcadastro.sistemaempresarial.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
@CrossOrigin("*")
@RequestMapping("/fotos")


public class FotoController {
    @Autowired //springboot instancia classe
    private FotoService fotoService;
    @PostMapping("/clientes/{id}")
    public ResponseEntity<String> carregaFoto(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file ) throws IOException {
        return fotoService.armazenaFoto(id,file);
    }

}


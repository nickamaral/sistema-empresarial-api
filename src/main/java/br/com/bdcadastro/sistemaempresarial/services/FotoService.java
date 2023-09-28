package br.com.bdcadastro.sistemaempresarial.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FotoService{
    public ResponseEntity<String> armazenaFoto(Long id, MultipartFile file){try{
        // Caminho completo do diretório de destino
        String destinationDirectory = "C:\\Users\\nicol\\Documents\\projeto-sistema-empresarial-api\\fotos-clientes\\";

        // Nome original do arquivo

            String filename = "random_filename.png"; // Give a random filename here.
            byte[] bytes = file.getBytes();
            String nomeCompletoDoArquivo = destinationDirectory + filename; // Directory path where you want to save ;
            Files.write(Paths.get(nomeCompletoDoArquivo), bytes);

            return ResponseEntity.ok(filename);
        }

        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o arquivo.");
        }
    }
}

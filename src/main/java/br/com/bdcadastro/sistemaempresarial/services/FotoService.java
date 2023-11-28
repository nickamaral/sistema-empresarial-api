package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.dtos.FotoResponseDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
public class FotoService{
    @Autowired
    private ClienteService clienteService;
    private String destinationDirectory = "C:\\Users\\nicol\\Documents\\projeto-sistema-empresarial-api\\fotos-clientes\\";

    public ResponseEntity<FotoResponseDTO> armazenaFoto(Long id, MultipartFile file){try{
        String nomeCompletoDoArquivo = pegaNomeDoArquivoCompleto(id);
            byte[] bytes = file.getBytes();
            Files.write(Paths.get(nomeCompletoDoArquivo), bytes);
            FotoResponseDTO fotoResponseDTO = new FotoResponseDTO(nomeCompletoDoArquivo.replace(destinationDirectory,""));
            return ResponseEntity.ok(fotoResponseDTO); //para nao ir novmente ao banco
        }

        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FotoResponseDTO("erro ao carregar a imagem"));
        }
    }

    public ResponseEntity<byte[]> recebeFoto(Long id) throws IOException {
        String nomeCompletoDoArquivo = pegaNomeDoArquivoCompleto(id);
        File file = new File(nomeCompletoDoArquivo);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
        header.add("Content-Type", "image/png");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.IMAGE_PNG)
                .body(Files.readAllBytes(Paths.get(nomeCompletoDoArquivo)));
    }
    private String pegaNomeDoArquivoCompleto(Long id){
        String fileName = getFileName(id);
        return destinationDirectory + fileName;
    }
    private String getFileName(Long id){
        ClienteEntity clienteEntity = clienteService.buscaPorIdOuJogaException(id);
        return clienteEntity.getCpf()+".png";

    }
}

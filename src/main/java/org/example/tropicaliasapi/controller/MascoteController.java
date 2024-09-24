package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Mascote;
import org.example.tropicaliasapi.service.EstadoService;
import org.example.tropicaliasapi.service.MascoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Mascote")
@RestController
@RequestMapping("/mascote")
public class MascoteController {
    MascoteService mascoteService;

    public MascoteController(MascoteService mascoteService) {
        this.mascoteService = mascoteService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos os mascotes dos usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascotes retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Mascote.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(mascoteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar mascote pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascote retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascote.class))
            ),
            @ApiResponse(responseCode = "404", description = "Mascote não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Mascote mascote = mascoteService.getById(id);
        if (mascote == null) {
            return new ResponseEntity<>("O mascote não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mascote, HttpStatus.OK);
    }

    @GetMapping("/usermascote/{userid}")
    @Operation(summary = "Procurar mascote pelo id do seu usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascote retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Mascote.class))
            ),
            @ApiResponse(responseCode = "404", description = "Mascote não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByUserId(@PathVariable("userid") Long id) {
        Mascote mascote = mascoteService.getById(id);
        if (mascote == null) {
            return new ResponseEntity<>("O mascote não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mascote, HttpStatus.OK);
    }
}

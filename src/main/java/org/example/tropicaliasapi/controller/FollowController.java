package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tropicaliasapi.model.Estado;
import org.example.tropicaliasapi.model.Follow;
import org.example.tropicaliasapi.service.EstadoService;
import org.example.tropicaliasapi.service.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Follow")
@RestController
@RequestMapping("/follow")
public class FollowController {
    FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping
    @Operation(summary = "Procurar todos as Interações entre usuários que se seguem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Follows retornadas com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Estado.class)))
            ),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(followService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procurar follow pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Follow retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estado.class))
            ),
            @ApiResponse(responseCode = "404", description = "Follow não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<?> getByID(@PathVariable("id") Long id) {
        Follow follow = followService.getById(id);
        if (follow == null) {
            return new ResponseEntity<>("O follow não foi encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }
}

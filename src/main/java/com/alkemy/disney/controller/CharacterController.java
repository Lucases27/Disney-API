package com.alkemy.disney.controller;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
        CharacterDTO savedCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(characterService.getAll());
    }

}
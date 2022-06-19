package com.argentinaprograma.ap.controller;

import com.argentinaprograma.ap.models.Experiencia;
import com.argentinaprograma.ap.models.Skills;
import com.argentinaprograma.ap.services.ExperienciaService;
import com.argentinaprograma.ap.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List<Skills> skills= skillsService.buscarSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills){
        Skills updateSkills = skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills) {
        Skills nuevaSkill = skillsService.addSkills(skills);
        return new ResponseEntity<>(nuevaSkill, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable("id") Long id){
        skillsService.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package queivan.harcmiliada.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import queivan.harcmiliada.domain.QuestionDto;
import queivan.harcmiliada.facade.QuestionFacade;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionFacade facade;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<QuestionDto> getAll(){
        return facade.getAll();
    }

    @GetMapping(value = "/current", produces = APPLICATION_JSON_VALUE)
    public QuestionDto getCurrent(){
        return facade.getCurrent();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public QuestionDto getById(@PathVariable String id){
        return facade.getById(id);
    }

    @PutMapping(value = "/current/{id}", produces = APPLICATION_JSON_VALUE)
    public QuestionDto setCurrent(@PathVariable String id){
        return facade.setCurrent(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public QuestionDto create(@RequestBody QuestionDto dto){
        return facade.create(dto);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public QuestionDto update(@RequestBody QuestionDto dto){
        return facade.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        facade.delete(id);
    }

}

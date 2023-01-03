package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.developer.DeveloperData;
import KvXGroup.CollectionRegistor.developer.DeveloperRepository;
import KvXGroup.CollectionRegistor.developer.DeveloperToList;
import KvXGroup.CollectionRegistor.exception.ResourceNotFoundException;
import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/developer")
public class Developer {

    @Autowired
    private DeveloperRepository DeveloperRepo;

    @GetMapping
    public Page<DeveloperToList> getDevelopers(@PageableDefault(size = 10, sort = {"name"})Pageable pagination){
        var developerRaw = DeveloperRepo.findAll(pagination).map(DeveloperToList::new);
        if(developerRaw.isEmpty()){
            throw new ResourceNotFoundException(String.format("failed to list developer"));
        }
        return developerRaw;
    }

    @GetMapping({"/{id}"})
    public Optional<KvXGroup.CollectionRegistor.developer.Developer> getDeveloperById(@PathVariable Long id){
        var developerRaw = DeveloperRepo.findById(id);
        if(developerRaw.isEmpty()){
            throw new ResourceNotFoundException(String.format("developer id %s not found", id));
        }

        return developerRaw;
    }

    @PostMapping
    @Transactional
    public String createDeveloper(@RequestBody DeveloperData request){
        DeveloperRepo.save(new KvXGroup.CollectionRegistor.developer.Developer(request));

        return request.name()+" developer registered successfully";
    }

    @PutMapping("/{id}")
    @Transactional
    public String updateDeveloper(@RequestBody DeveloperData request, @PathVariable Long id){
        var developer = DeveloperRepo.getReferenceById(id);

        developer.updateDeveloper(request);

        return request.name()+" updated successfully";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteDeveloper(@PathVariable Long id){
        DeveloperRepo.deleteById(id);

        return "developer deleted successfully";
    }
}

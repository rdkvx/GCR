package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.developer.DeveloperData;
import KvXGroup.CollectionRegistor.developer.DeveloperRepository;
import KvXGroup.CollectionRegistor.developer.DeveloperToList;
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
        return DeveloperRepo.findAll(pagination).map(DeveloperToList::new);
    }

    @GetMapping({"/{id}"})
    public Optional<KvXGroup.CollectionRegistor.developer.Developer> getDeveloperById(@PathVariable Long id){
        return DeveloperRepo.findById(id);
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

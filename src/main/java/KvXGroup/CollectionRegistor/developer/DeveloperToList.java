package KvXGroup.CollectionRegistor.developer;

public record DeveloperToList (Long id, String name){
    public DeveloperToList(Developer d){
        this(d.getId(), d.getName());
    };
}

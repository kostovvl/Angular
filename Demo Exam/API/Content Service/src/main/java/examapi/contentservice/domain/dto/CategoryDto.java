package examapi.contentservice.domain.dto;

public class CategoryDto extends BaseDto {

    private String name;

    public CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

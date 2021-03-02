import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "categories")
public class CategoriesList {
    private List<Categories> categories;

    public CategoriesList(List<Categories> categories) {
        this.categories = categories;
    }

    public CategoriesList() {
        this.categories = new ArrayList<>();
    }

    @XmlElement(name = "category")
    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "CategoriesList{" +
                "categories=" + categories +
                '}';
    }
}

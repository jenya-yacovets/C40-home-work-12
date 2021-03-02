import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainTask1 {
    public static void main(String[] args) {

        try {
            JAXBContext content = JAXBContext.newInstance(CategoriesList.class, Categories.class, Products.class);
            Unmarshaller unmarshaller = content.createUnmarshaller();
            CategoriesList categoriesList = (CategoriesList) unmarshaller.unmarshal(new File("categories.xml"));
            System.out.println(categoriesList);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

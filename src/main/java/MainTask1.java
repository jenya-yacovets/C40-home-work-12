import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTask1 {
    public static void main(String[] args) {

        CategoriesList categoriesList = null;

        try {
            JAXBContext content = JAXBContext.newInstance(CategoriesList.class, Categories.class, Products.class);
            Unmarshaller unmarshaller = content.createUnmarshaller();
            categoriesList = (CategoriesList) unmarshaller.unmarshal(new File("categories.xml"));
            System.out.println("Файл успешно прочитан");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (categoriesList != null) {

            List<Products> allProducts = new ArrayList<>();

            for (Categories cat : categoriesList.getCategories()) {
                allProducts.addAll(cat.getProducts().stream().filter(item -> item.getPrice() < 500).collect(Collectors.toList()));
            }

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File("products.json"), allProducts);
                System.out.println("Данные в файл успешно записаны");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

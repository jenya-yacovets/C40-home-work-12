import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainTask2 {
    public static void main(String[] args) {

        CategoriesList categoriesList = null;

        try {
            JAXBContext content = JAXBContext.newInstance(CategoriesList.class, Categories.class, Products.class);
            Unmarshaller unmarshaller = content.createUnmarshaller();
            categoriesList = (CategoriesList) unmarshaller.unmarshal(new File("categories.xml"));
            System.out.println("Данные из файла успешно прочтены");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (categoriesList != null) {

            String str = "";

            for(Categories cat : categoriesList.getCategories()) {
                List<Products> products = cat.getProducts().stream().filter(p -> p.getPrice() > 300).collect(Collectors.toList());
                str += cat.getName() + ": " + products.size() + "\n";
            }

            try (FileWriter fileWriter = new FileWriter("test.txt")) {
                fileWriter.write(str);
                System.out.println("Файл успешно записан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

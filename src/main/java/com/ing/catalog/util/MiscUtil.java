package com.ing.catalog.util;

import com.ing.catalog.dto.UploadFileResponseDto;
import com.ing.catalog.entity.Product;
import com.ing.catalog.entity.ProductCategory;
import com.ing.catalog.repository.ProductCategoryRepository;
import com.ing.catalog.repository.ProductRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.Iterator;

@Component
public class MiscUtil {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public UploadFileResponseDto loadDataToDB(MultipartFile file) {

        UploadFileResponseDto response = new UploadFileResponseDto();
        FileInputStream input = null;
        XSSFSheet sheet = null;
        XSSFWorkbook workbook = null;
        try {

            workbook = new XSSFWorkbook(file.getInputStream());

            sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

               // String prodDesc = "";
                String categoryName="";
                String productName = "";
                String productDescription="";


                Product product = new Product();
                ProductCategory productCategoryRepo = new ProductCategory();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cellIterator.hasNext()) {
                        Cell cell1 = cellIterator.next();

                        System.out.println(cell1.getStringCellValue() + "tttttttttttttttttttttttt");
                        categoryName = cell1.getStringCellValue();
                    }

                    if (cellIterator.hasNext()) {
                        Cell cell3 = cellIterator.next();
                        System.out.println(cell3.getStringCellValue() + "fffffffffffffff");
                        productName = cell3.getStringCellValue();
                    }
                    if (cellIterator.hasNext()) {
                        Cell cell4 = cellIterator.next();
                        System.out.println(cell4.getStringCellValue() + "fffffffffffffffDescription");
                        productDescription = cell4.getStringCellValue();
                    }

                    productCategoryRepo.setCategoryName(categoryName);
                    ProductCategory productCategory2 = productCategoryRepository.save(productCategoryRepo);

                    //setting product category Id
                    product.setCategoryId(productCategory2.getCategoryId());


                    product.setProductDescription(productDescription);
                    product.setProductName(productName);

                    productRepository.save(product);
                }


                //setting productCategory
               /* productCategoryRepo.setCategoryName(categoryName);
                ProductCategory productCategory2 = productCategoryRepository.save(productCategoryRepo);

                //setting product category Id
                product.setCategoryId(productCategory2.getCategoryId());


                product.setProductDescription(productDescription);
                product.setProductName(productName);

                productRepository.save(product);*/

                response.setMessage("success");
                response.setStatusCode(200);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }
}

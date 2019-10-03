/*
package com.ing.catalog.util;

public class D {



    @Component
    public class ExcelImportToDB {

        private static final Logger logger = LogManager.getLogger(ExcelImportToDB.class);

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

                    String prodDesc = "";
                    double productCharges = 0.0;
                    String productName = "";
                    Cell cell = cellIterator.next();

                    Product product = new Product();
                    ProductCategory productCategoryRepo = new ProductCategory();

                    String productCategory = cell.getStringCellValue();
                    if (cellIterator.hasNext()) {
                        Cell cell1 = cellIterator.next();
                        productName = cell1.getStringCellValue();
                    }
                    if (cellIterator.hasNext()) {
                        Cell cell2 = cellIterator.next();
                        productCharges = cell2.getNumericCellValue();
                    }
                    if (cellIterator.hasNext()) {
                        Cell cell3 = cellIterator.next();
                        prodDesc = cell3.getStringCellValue();
                    }

                    productCategoryRepo.setCategoryName(productCategory);
                    ProductCategory productCategory2 = productCategoryRepository.save(productCategoryRepo);


                    product.setCategoryId(productCategory2.getCategoryId());

                    product.setCharges(productCharges);
                    product.setProductDescription(prodDesc);
                    product.setProductName(productName);

                    productRepository.save(product);

                    response.setMessage("success");
                    response.setStatusCode(200);

                }

            } catch (Exception e) {
                logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
            } finally {
                try {
                    if (workbook != null) {
                        workbook.close();
                    }
                    if (input != null) {
                        input.close();
                    }
                    sheet = null;
                } catch (Exception e) {
                    logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
                }

            }
            return response;
        }

    }







}
*/

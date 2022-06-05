package com.tienda.dto;

public class ProductDTO {

        private Long idProduct;
        private String nameProduct;
        private String descriptionProduct;
        private double priceProduct;
        private int stockProduct;
        private boolean statusProduct;

        public ProductDTO() {
            super();
        }

        public ProductDTO(Long idProduct, String nameProduct, String descriptionProduct, double priceProduct, int stockProduct,
                          boolean statusProduct) {
            super();
            this.idProduct = idProduct;
            this.nameProduct = nameProduct;
            this.descriptionProduct = descriptionProduct;
            this.priceProduct = priceProduct;
            this.stockProduct = stockProduct;
            this.statusProduct = statusProduct;
        }

        public Long getIdProduct() {
            return idProduct;
        }

        public void setIdProduct(Long idProduct) {
            this.idProduct = idProduct;
        }

        public String getNameProduct() {
            return nameProduct;
        }

        public void setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
        }

        public String getDescriptionProduct() {
            return descriptionProduct;
        }

        public void setDescriptionProduct(String descriptionProduct) {
            this.descriptionProduct = descriptionProduct;
        }

        public double getPriceProduct() {
            return priceProduct;
        }

        public void setPriceProduct(double priceProduct) {
            this.priceProduct = priceProduct;
        }

        public int getStockProduct() {
            return stockProduct;
        }

        public void setStockProduct(int stockProduct) {
            this.stockProduct = stockProduct;
        }

        public boolean isStatusProduct() {
            return statusProduct;
        }

        public void setStatusProduct(boolean statusProduct) {
            this.statusProduct = statusProduct;
        }

        @Override
        public String toString() {
            return "productDTO [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", descriptionProduct="
                    + descriptionProduct + ", priceProduct=" + priceProduct + ", stockProduct=" + stockProduct
                    + ", statusProduct=" + statusProduct + "]";
        }
}

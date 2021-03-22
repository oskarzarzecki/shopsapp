INSERT INTO product_type (name, available, deleted) VALUES ('ProductType1', 1, 0);
INSERT INTO product_type (name, available, deleted) VALUES ('ProductType2', 1, 0);
INSERT INTO product_type (name, available, deleted) VALUES ('ProductTypeNoCategories', 1, 0);
INSERT INTO product_type (name, available, deleted) VALUES ('ProductType3', 0, 0);
INSERT INTO product_type (name, available, deleted) VALUES ('ProductType4', 1, 1);
INSERT INTO product_type (name, available, deleted) VALUES ('ProductType5', 0, 1);

INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory1', 1, 0);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory2', 1, 0);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (2, 'ProductCategory3', 1, 0);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory4', 1, 1);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory5', 0, 0);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory6', 0, 1);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (1, 'ProductCategory7', 0, 1);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (2, 'ProductCategory8', 0, 0);
INSERT INTO product_category (product_type_id, name, available, deleted) VALUES (2, 'ProductCategory9', 1, 1);

INSERT INTO vat_rate (name, value, available, deleted) VALUES ('VAT 20%', 20, 1, 0);

INSERT INTO product (product_category_id, name, vat_rate_id, available, deleted) VALUES (1, 'Product1', 1, 1, 0);
INSERT INTO product (product_category_id, name, vat_rate_id, available, deleted) VALUES (1, 'Product2', 1, 1, 0);

INSERT INTO auction (name, description_short, product_id, price_netto, price_brutto, promoted, active, available, deleted) VALUES ('Auction1', 'Auction1 description', 1, 1000, 1200, 50, 1, 1, 0);
INSERT INTO auction (name, description_short, product_id, price_netto, price_brutto, promoted, active, available, deleted) VALUES ('Auction2', 'Auction2 description', 2, 1000, 1200, 100, 1, 1, 0);
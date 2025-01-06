INSERT INTO category (id, name, description)
VALUES (1, 'Electronics', 'Категорія для електроніки');

INSERT INTO category (id, name, description)
VALUES (2, 'Clothing', 'Категорія для одягу');

INSERT INTO category (id, name, description)
VALUES (3, 'Home Appliances', 'Категорія для побутової техніки');

INSERT INTO product (id, name, available_quantity, price, category_id, description)
VALUES (nextval('product_seq'), 'Laptop', 25, 799.99, 1, 'Ноутбук для роботи та відпочинку');

INSERT INTO product (id, name, available_quantity, price, category_id, description)
VALUES (nextval('product_seq'), 'T-shirt', 50, 19.99, 2, 'Трендова футболка для літа');

INSERT INTO product (id, name, available_quantity, price, category_id, description)
VALUES (nextval('product_seq'), 'Vacuum Cleaner', 10, 129.99, 3, 'Потужний пилосос для дому');

INSERT INTO product (id, name, available_quantity, price, category_id, description)
VALUES (nextval('product_seq'), 'Iphone', 25, 100.99, 1, 'Iphone для роботи та відпочинку');



-- Categorías
INSERT INTO category (name) VALUES ('Utiles Escolares');
INSERT INTO category (name) VALUES ('Tecnologia');
INSERT INTO category (name) VALUES ('Papeleria');

-- Productos
INSERT INTO product (name, price, stock, category_id) VALUES ('Cuaderno A4', 5.50, 100, 1);
INSERT INTO product (name, price, stock, category_id) VALUES ('Lápiz HB', 1.20, 200, 1);
INSERT INTO product (name, price, stock, category_id) VALUES ('Laptop', 1200.50, 0, 2);
INSERT INTO product (name, price, stock, category_id) VALUES ('Mouse inalambrico', 25.00, 0, 2);



-- Clientes
INSERT INTO customer (name, email, phone, address)
VALUES ('Juan Pérez', 'juan@example.com', '987654321', 'Av. Siempre Viva 742, Lima');
INSERT INTO customer (name, email, phone, address)
VALUES ('María López', 'maria@example.com', '912345678', 'Calle Falsa 123, Arequipa');
-- Ventas
INSERT INTO sale (customer_id, sale_date, total) VALUES (1, NOW(), 12.20);

-- Detalle de venta
INSERT INTO sale_detail (sale_id, product_id, quantity, price) VALUES (1, 1, 2, 5.50);
INSERT INTO sale_detail (sale_id, product_id, quantity, price) VALUES (1, 2, 1, 1.20);

A program that reflects the following situation.
Your company has been contracted to develop software for a large JavaMarkt online store. 
One of the core functionalities is shopping cart software, 
which can take into account various promotions, discounts and special offers, such as:
- if the value of the order is more than 300 PLN the customer receives a 5% discount on the purchased goods
- if the customer buys 2 products, the 3rd cheapest one is given for free
- if the value of the order exceeds PLN 200 the customer receives a company mug free of charge
- one-time 30% discount coupon for a selected product
and many others still unknown at this stage of implementation. 
Promotions may change during the operation of the program, i.e. new ones may appear and existing ones may disappear.

The goods in the shopping cart should be sorted in descending order by price, 
and then by alphabetical order of product names. 
The way the products are sorted can change as the program runs. 

Your task is to implement logic, operating on objects of type product.Product, 
which would enable:
1. search for the cheapest/most expensive product in a given collection of products
2. searching for the n cheapest/most expensive products in the given product collection
3 Sorting a collection of products by price as well as by name
4. calculation of the sum of prices of all specified products
Application of the types of promotions described above on the preset collection of products in the shopping cart

Features related to the class product.Product:
- product code - String
- product name - String
- product price - double
- product price after taking into account the promotion - double

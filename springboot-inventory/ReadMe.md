### :Installation & Running the server: 
---

#### Create the database in mysql server with script under src\main\resources\templates

#### Run the class - AirbusManagementSpringApplication springboot class

#### Login to application is by using 

```
Post Request - http://localhost:8080/airbusManagement/JWT/authenticateUser

Json Request

{"username":"airbus02", 
 "password":"1234"
}

```

#### GET all products 

```
Get Request - http://localhost:8080/airbusManagement/getAllProducts

Header - { 'Authorization', Bearer ${token} }

Token is from Login url

```

#### GET all products of a given category
	
```
Get Request - http://localhost:8080/airbusManagement/getProductsByCategory/{categoryName}

Header - { 'Authorization', Bearer ${token} }

Token is from Login url
```

#### Add Product

```
Post Request - http://localhost:8080/airbusManagement/addProduct

  Json data - {
	"productId":"",
	"productName":"",
	"productDescription":"",
	"productCategory":"",
	"units":""} 
  
Header - { 'Authorization', Bearer ${token} }

Token is from Login url

```

#### Update Product

```
Post Request - http://localhost:8080/airbusManagement/updateProduct/{ProductId}

  Json data - {
	"productId":"",
	"productName":"",
	"productDescription":"",
	"productCategory":"",
	"units":""} 
  
Header - { 'Authorization', Bearer ${token} }

Token is from Login url

Note: This API can be changed to PUT

```

#### Delete Product

```
Delete Request - http://localhost:8080/airbusManagement/deleteProduct/{ProductId}

Header - { 'Authorization', Bearer ${token} }

Token is from Login url

```

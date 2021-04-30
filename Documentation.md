# rent-information-service

## Authentication
One user is available.

**Username**: `rokas`

**Password**: `rokas1`

## API calls
### List products
Fetches products available to rent.

* **URL**

  /api/v1/products

* **Method**

  `GET`

* **URL Params**

  N/A

* **Data Params**

  N/A

* **Success Response**

  * **Code**: 200 OK
  * **Content**: `[{"id":1,"title":"Skis"},{"id":2,"title":"Snowboard"},...]`


* **Error Response**

  * **Code**: 401 UNAUTHORIZED


* **Sample Call**

   ```
   curl --location --request GET 'http://localhost:8080/api/v1/products' \
   --header 'Authorization: Basic cm9rYXM6cm9rYXMx' \
   --header 'Cookie: JSESSIONID=748E420446F0264E69924105E66B699E'
   ```


### Show product details
Fetches individual product details.

* **URL**

  /api/v1/details

* **Method**

  `GET`

* **URL Params**

  **Required**:

  ``id=[integer]``

* **Data Params**

  N/A

* **Success Response**

  * **Code**: 200 OK
  * **Content**: `{"id":1,"title":"Skis","commitmentMonths":[0,3,6]}`


* **Error Response**

  * **Code**: 400 BAD_REQUEST

  * **Code**: 401 UNAUTHORIZED

  * **Code**: 404 NOT_FOUND


* **Sample Call**

   ```
   curl --location --request GET 'http://localhost:8080/api/v1/details?id=1' \
   --header 'Authorization: Basic cm9rYXM6cm9rYXMx' \
   --header 'Cookie: JSESSIONID=748E420446F0264E69924105E66B699E'
   ```


### Delete product
Deletes a product.

* **URL**

  /api/v1/delete

* **Method**

  `GET`

* **URL Params**

  **Required**:

  ``id=[integer]``

* **Data Params**

  N/A

* **Success Response**

  * **Code**: 200 OK


* **Error Response**

  * **Code**: 400 BAD_REQUEST

  * **Code**: 401 UNAUTHORIZED

  * **Code**: 404 NOT_FOUND


* **Sample Call**

   ```
   curl --location --request GET 'http://localhost:8080/api/v1/delete?id=1' \
  --header 'Authorization: Basic cm9rYXM6cm9rYXMx' \
  --header 'Cookie: JSESSIONID=A3E8A8255D27A1501BAF8BBCA9157DEA'
   ```


### Calculate order price
Fetches order price depending on product, commitment, months of return.

* **URL**

  /api/v1/price

* **Method**

  `POST`

* **URL Params**

  N/A

* **Data Params**

  JSON format.

  **Required**:

  `"id":[integer]`

  **Optional**:

  `"commitment":[integer]`. Must be one of {3, 6}.

  `"returnMonths":[integer]`. Must be greater than or equal to 0.

* **Success Response**

  * **Code**: 200 OK
  * **Content**: `70.0`


* **Error Response**

  * **Code**: 400 BAD_REQUEST

  * **Code**: 401 UNAUTHORIZED

  * **Code**: 404 NOT_FOUND


* **Sample Call**

   ```
   curl --location --request POST 'http://localhost:8080/api/v1/price' \
  --header 'Authorization: Basic cm9rYXM6cm9rYXMx' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: JSESSIONID=748E420446F0264E69924105E66B699E' \
  --data-raw '{"id":1,"commitment":3,"returnMonths":1}'
   ```

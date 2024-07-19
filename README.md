# MyFarm
My Farm Reports

This Repository contains the API's code to produce the results of 
Harvested details and Planted details for every corp and for every farm.

1. Planted API will take one parameter, which is farmName.
 return results of 
a. Planting Area (in acres)
b. Amount of expected product (in tons)
c. crop name

2. Harvested API will take take one parameter, which is farmName.
will return
a. amount of harvested product (in tons)
b. crop name


Database:

using h2 in memory database which gets initialised from the spring boot startup.
accessing database by using : localhost:9000/h2-console

Documentation:

used swagger2 for api documentation.
swagger ui can be found: http://localhost:9000/swagger-ui.html
we can try both planted and harvested API's using try it out button by entering 'testfarm' as URL variable



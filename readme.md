Download & install Mongo DB
Start the Mongo DB by navigating to the bin folder of the Mongo DB -> execute the application mongod.exe via command prompt/directly clicking on the Mongod.exe icon
Start the Mongo Shell by navigating to the bin folder of the Mongo DB -> type mongo via command prompt
create a database using the command "use <<database name>>" in this case use Bookstore
create a collection using the command "db.createCollection(<<collection name>>)" in this case db.createCollection('books')
Insert the contents of db.json file present in the data directory using the following command: db.books.insert(<<db.json file content>>);
export the war to a Tomcat Server & hit the url - http://localhost:8080/bookstore
The Swagger UI url is http://localhost:8080/bookstore/swagger-ui.html
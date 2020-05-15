Choosen patters:

Singleton
Applied in the SetUpDBData to have only one instance of the Database Connection, instead of creating a new instance every time we needed
to access the Database

Builder
Applied in the Investor and Company classes, to have a more reliable and maintainable code if in the future we decide to increase
the number of fields to create the object, and also providing control over steps of the object construction process

DAO
A database was created on Google Cloud to store all Investors and Companies data, with the objective of hiding from the application all the complexities involved in performing create, read, update and delete (CRUD) operations in the underlying storage mechanism.

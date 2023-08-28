import mysql.connector

def insertarUsuario(user_data):
    pais = user_data['pais']
    
    # Configura las credenciales de conexión para cada nodo MySQL
    if pais == 'USA':
        db_config = {
            'user': 'root',
            'password': '123456',
            'host': 'localhost',  # O la dirección IP de tu nodo MySQL de EE. UU.
            'database': 'users_usa',
            'port': 3306  # Puerto MySQL
        }
    elif pais == 'Canada':
        db_config = {
            'user': 'root',
            'password': '123456',
            'host': 'localhost',  # O la dirección IP de tu nodo MySQL de Canadá.
            'database': 'users_canada',
            'port': 3307  # Puerto MySQL
        }
    else:
        # Manejar otros casos o errores
        return

    try:
        # Establece una conexión con la base de datos
        connection = mysql.connector.connect(**db_config)

        # Crea un cursor para ejecutar consultas SQL
        cursor = connection.cursor()

        # Ejecuta una consulta SQL para insertar un usuario (reemplaza esto con tus datos)
        insert_query = "INSERT INTO Tabla1 (pais, nombre, correo) VALUES (%s, %s, %s)"

        # Define los valores del usuario a insertar
        user_values = (user_data['pais'], user_data['nombre'], user_data['correo'])

        cursor.execute(insert_query, user_values)

        # Realiza la inserción y confirma los cambios
        connection.commit()

        # Cierra el cursor y la conexión
        cursor.close()
        connection.close()

        print("Inserción exitosa")

    except mysql.connector.Error as error:
        print("Error al insertar usuario:", error)

# Ejemplo de uso
user_data = {
    'pais': 'Canada',
    'nombre': 'Pepe',
    'correo': 'pepe@gmail.com',
   
}

insertarUsuario(user_data)
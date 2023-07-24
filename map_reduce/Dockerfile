#Dockerfile
FROM python:3

#Copiar los scripts del MapReduce al contenedor
COPY mapReduce.py /app/mapReduce.py

#Establecer el directorio de trabajo
WORKDIR /app

#Instalar las dependencias necesarias
RUN pip install mrjob

#Ejecutar el script cuando el contenedor se inicie
#CMD [ "python", "mapReduce.py" ]
import multiprocessing
import time

if __name__ == "__main__":

    #Crear cola de tareas
    cola_tareas = multiprocessing.Queue()
    tareas = ["Tarea1", "Tarea2", "Tarea3", "Tarea4"]

    for tarea in tareas:
        cola_tareas.put(tarea)

    #Funcion para asignar tareas
    def asignar_tareas(nodo):
        while cola_tareas.qsize() > 0:
            tarea = cola_tareas.get()
            print("Nodo ", nodo, " esta procesando la tarea ", tarea)
            time.sleep(3)
            print("Nodo ", nodo, " ha completado la tarea ", tarea)

    #Crear nodos
    procesos = []
    for nodo in ["Nodo A", "Nodo B", "Nodo C"]:
        proceso = multiprocessing.Process(target = asignar_tareas,args=(nodo,))
        proceso.start()
        procesos.append(proceso)

    #Esperar que todos los procesos terminen
    for proceso in procesos:
        proceso.join()

    print("Procesos terminados")
import random
import time
from operator import itemgetter

# Made by Jose Daniel Saldaña Flores @ https://github.com/DanielFL0
# Develop instance generator.
# Develop a write to file function.
# Develop a read from file function.
# Develop 3 heuristics (by weight, by value, by ratio).

def instance_generator():
    """
    Instance generator function.
    A function that takes 5 inputs: instance_number, minimum_value, maximum_value,
    minimum_weight and maximum_weight.
    It then proceeds to send the inputs to the write_file function.
    """
    # Input for the number of instance that we want to generate.
    instances_number = 1000000 # int(input("Ingresa el numero de instancias que desea generar: "))
    # Input for the minimum value that we want to generate.
    minimum_value = 2 # int(input("Ingresa el valor minimo: "))
    # Input for the maximum that we want to generate.
    maximum_value = 50 # int(input("Ingresa el valor maximo: "))
    # Input for the minimum weight that we want to generate.
    minimum_weight = 4 # int(input("Ingresa el peso minimo: "))
    # Input for the maximum weight that we want to generate.
    maximum_weight = 68 # int(input("Ingresa el peso mayor: "))
    # Calls the write file function.
    write_file(instances_number, minimum_value, maximum_value, minimum_weight, maximum_weight)

def write_file(instances_number, minimum_value, maximum_value, minimum_weight, maximum_weight):
    """
    Write file function.
    A function that given 5 inputs it generates a .dat file that includes all the data generated.
    """
    filename = "instance.dat"
    with open(filename, 'w') as file_object:
        file_object.write("n" + "     " + "v" + "     " + "w" + "\n")
        for i in range(instances_number):
            v = random.randint(minimum_value, maximum_value)
            w = random.randint(minimum_weight, maximum_weight)
            file_object.write(str(i) + "     " + str(v) + "     " + str(w) + "\n")

def read_file(filename):
    """
    Read file function.
    A function that reads the .dat file and proceeds to convert the data (given as a String data type)
    to integer data type.
    """
    # Numbers list that contains all the data from the .dat file.
    numbers = []
    # Weights list that contains all the weights respectively.
    weights = []
    # Opens a filename in read mode.
    with open(filename, 'r') as file_object:
        # The readLines function returns all lines in a file, the [1:] slice skips the first line. 
        lines = file_object.readlines()[1:]
        # A loop that goes through all lines in the file.
        for line in lines:
            # The split function returns a list of all the data in the line.
            line = line.split()
            # List comprehension to cast int to all string type values.
            line = [ int(x) for x in line ]
            # ratio = value / weight.
            ratio = line[1] / line[2]
            # append function to add the ratio to the line list.
            line.append(ratio)
            weights.append(line[2])
            # Tuple cast to convert our lists to tuples.
            numbers.append(tuple(line))
    # Use the len function to find out the total number of instances.
    instances = len(numbers)
    # Use W = n * (Wmin + Wmax) / 2 * 0.3
    capacity = instances * (min(weights) + max(weights) / 2) * 0.3
    # Return a tuple of the capacity and values with weights.
    return capacity, numbers

def heuristic():
    """
    Heuristic function.
    A function that runs any of the 3 heuristics.
    """
    # Calls the read file function.
    capacity, numbers = read_file("instance.dat")
    print(capacity)
    # Store the heuristic option as an int value.
    heuristic_option = 3 # int(input("Cual heuristica desea correr? \n 1.- Por peso \n 2.- Por valor \n 3.- Por radio \n Opcion: "))
    # List that will contain either the value or weight of items in the knapsack.
    knapsack = []
    # List that will contain the item's ID in the knapsack.
    item_id = []
    # Sum of all item's weight in the knapsack.
    weight_sum = 0

    if heuristic_option == 1:
        numbers = sorted(numbers, key=itemgetter(2))
        for i in range(len(numbers)):
            if numbers[i][2] <= capacity:
                knapsack.append(numbers[i][2])
                item_id.append(numbers[i][0])
                capacity -= numbers[i][2]
                weight_sum += numbers[i][2]
            else:
                break
        print(knapsack)
        print(item_id)
        print(weight_sum)
        
    elif heuristic_option == 2:
        numbers = sorted(numbers, key=itemgetter(1), reverse=True)
        for i in range(len(numbers)):
            if numbers[i][2] <= capacity:
                knapsack.append(numbers[i][1])
                item_id.append(numbers[i][0])
                capacity -= numbers[i][2]
                weight_sum += numbers[i][2]
            else:
                break
        print(knapsack)
        print(item_id)
        print(weight_sum)

    elif heuristic_option == 3:
        start_time = time.time()
        numbers = sorted(numbers, key=itemgetter(3), reverse=True)
        for i in range(len(numbers)):
            if numbers[i][2] <= capacity:
                knapsack.append(numbers[i][3])
                item_id.append(numbers[i][0])
                capacity -= numbers[i][2]
                weight_sum += numbers[i][2]
            else:
                break
        # print(knapsack)
        # print(item_id)
        print(weight_sum)

start_time = time.time()
instance_generator()
heuristic()
print(time.time() - start_time)
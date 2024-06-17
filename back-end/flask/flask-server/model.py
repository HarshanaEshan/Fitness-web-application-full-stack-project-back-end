import pandas as pd
from sklearn.linear_model import LinearRegression

class Model:
    def __init__(self):
        self._my_variable = None  # Initialize the variable
    # Getter method
    def get_my_variable(self):
        return self._my_variable

    # Setter method
    def set_my_variable(self, value):
        self._my_variable = value
        
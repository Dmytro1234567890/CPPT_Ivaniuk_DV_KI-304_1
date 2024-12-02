import os

class Pond:
    def __init__(self, length=0, width=0, depth=0):
        """
        Базовий клас для водойм.
        :param length: Довжина водойми
        :param width: Ширина водойми
        :param depth: Глибина водойми
        """
        self.length = length
        self.width = width
        self.depth = depth
        self.log_file_name = "pond_log.txt"
        self._log_file = open(self.log_file_name, "w")

    def set_length(self, length):
        self.length = length

    def set_width(self, width):
        self.width = width

    def set_depth(self, depth):
        self.depth = depth

    def get_length(self):
        return self.length

    def get_width(self):
        return self.width

    def get_depth(self):
        return self.depth

    def area(self):
        result = self.length * self.width
        self._log(f"Area: {result} km^2")
        return result

    def volume(self):
        result = self.length * self.width * self.depth
        self._log(f"Volume: {result} km^3")
        return result

    def perimeter(self):
        result = 2 * (self.length + self.width)
        self._log(f"Perimeter: {result} km")
        return result

    def max_value(self):
        result = max(self.length, self.width, self.depth)
        self._log(f"Max value: {result}")
        return result

    def scale(self, scale_factor):
        self.length *= scale_factor
        self.width *= scale_factor
        self.depth *= scale_factor
        self._log(f"Scaled dimensions by {scale_factor}")

    def calculate_volume_by_percentage(self, percentage):
        if not (0 <= percentage <= 100):
            print("The percentage must be between 0 and 100.")
            return None
        result = self.length * self.width * self.depth * (percentage / 100)
        self._log(f"Volume ({percentage}%): {result} km^3")
        return result

    def determine_depth(self):
        if self.depth >= 1:
            self._log(f"The pond is deep. Its depth is {self.depth} km.")
        else:
            self._log(f"The pond is shallow. Its depth is {self.depth} km.")

    def _log(self, message):
        self._log_file.write(message + "\n")
        self._log_file.flush()

    def dispose(self):
        self._log_file.close()
        if os.path.exists(self.log_file_name):
            print(f"Log saved to {self.log_file_name}")

    def unique_feature(self):
        """Абстрактний метод, який реалізується у похідних класах."""
        raise NotImplementedError("This method should be implemented by subclasses.")

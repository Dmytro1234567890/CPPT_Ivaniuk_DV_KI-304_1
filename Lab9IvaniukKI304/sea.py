from pond import Pond

class Sea(Pond):
    def __init__(self, length, width, depth, salinity):
        super().__init__(length, width, depth)
        self.salinity = salinity

    def unique_feature(self):
        self._log("The sea has a unique feature: tidal waves.")

    def log_sea_properties(self):
        self._log(f"Sea Properties: Length = {self.length} km, Width = {self.width} km, "
                  f"Depth = {self.depth} km, Salinity = {self.salinity}‰.")

from sea import Sea
def main():

    sea = Sea(12, 10, 2, 35.0)
    sea.set_length(1026)
    print(f"Length: {sea.get_length()} km")
    sea.set_width(521)
    print(f"Width: {sea.get_width()} km")
    sea.set_depth(3)
    print(f"Depth: {sea.get_depth()} km")

    sea.area()
    sea.volume()
    sea.perimeter()
    sea.max_value()
    sea.calculate_volume_by_percentage(70)
    sea.scale(3)
    sea.determine_depth()
    sea.log_sea_properties()

    sea.dispose()

if __name__ == "__main__":
    main()

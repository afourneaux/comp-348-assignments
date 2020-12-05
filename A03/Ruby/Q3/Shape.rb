##
# Shape class:
# Defines a superclass Shape which can be extended.
# 
# Methods:
# print() -> Prints shape's name, area, perimeter
# area() -> Returns the shape's area
# perimeter() -> Returns the shape's perimeter
#
# NOTE: This class offers a default implementation for the area() 
#       and perimeter() methods which returns nil.
##

class Shape

    #Default constructor
    def initialize() end

    #Print method
    def print()
        area = self.area();
        perimeter = self.perimeter();
        puts("#{self.class.name}, perimeter: #{perimeter!=nil ? perimeter : "undefined"}, area: #{area!=nil ? area : "undefined"}");
    end

    #Default methods
    def area() return nil; end
    def perimeter() return nil; end

end
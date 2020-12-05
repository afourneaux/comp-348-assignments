##
# Rectangle class:
# Defines a rectangle - initialized with a width and height values
# 
# Methods:
# area() -> Returns the rectangle's area
# perimeter() -> Returns the rectangle's perimeter
##
require("./Shape.rb")

class Rectangle < Shape

    #Constructor
    def initialize(width, height) 
        if (width == nil || height == nil || width < 0) || (height < 0)
            raise "Invalid Rectangle: Width and Height need to be positive numbers.";
        end
        @width = width;
        @height = height;
    end

    #Methods
    def area()
         return @width * @height;
    end

    def perimeter()
        return (2 * @height) + (2 * @width);
    end

end
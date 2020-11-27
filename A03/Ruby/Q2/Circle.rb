##
# Circle class:
# Defines a circle - initialized with a radius value
#
# Note that a circle is an ellipse where a == b
# 
# Methods:
# area() -> Returns the circle's area
# perimeter() -> Returns the circle's perimeter
##
require("./Ellipse.rb")

class Circle < Ellipse

    #Constructor
    def initialize(radius) 
        if (radius==nil || radius < 0)
            raise "Invalid Circle: Radius needs to be a positive number";
        end
        super(radius, radius);
        @radius = radius;
    end

    #Methods
    def perimeter()
        return 2 * Math::PI * @radius;
    end

end
##
# Ellipse class:
# Defines an ellipse - initialized with a semi-major and a semi-minor axis
# 
# Methods:
# area() -> Returns the ellipse's area
# perimeter() -> Returns the ellipse's perimeter
##
require("./Shape.rb")

class Ellipse < Shape

    #Constructor
    def initialize(a, b) 
        if (a == nil || b == nil || a < 0 || b < 0)
            raise "Invalid Ellipse: SemiMajor and SemiMinor need to be positive numbers";
        end
        @semiMajor = [a, b].max;
        @semiMinor = [a, b].min;
    end

    #Methods
    def area()
         return Math::PI * @semiMajor * @semiMinor;
    end

    def eccentricity()
        return Math.sqrt(@semiMajor**2 - @semiMinor**2);
    end


end
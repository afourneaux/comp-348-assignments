require("./Circle.rb");
require("./Rectangle.rb");

#Test classes implementation
shape = Shape.new();
#ellipse = Ellipse.new(1, 2); #ERROR
ellipse = Ellipse.new(5, 3);
circle = Circle.new(2);
rectangle = Rectangle.new(1, 2);

shape.print();
circle.print();
rectangle.print();
ellipse.print();
puts("Ellipse Eccentricity: #{ellipse.eccentricity()}");
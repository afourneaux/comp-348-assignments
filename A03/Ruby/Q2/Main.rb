require("./Circle.rb");
require("./Rectangle.rb");

File.open("./shapes.txt", "r") do |file|
    file.each_line do |line|
      sections = line.split(" ");
      begin
        case sections[0]
        when "shape"
            shape = Shape.new();
        when "rectangle"
            shape = Rectangle.new(sections[1].to_f(), sections[2].to_f());
        when "circle"
            shape = Circle.new(sections[1].to_f());
        when "ellipse"
            shape = Ellipse.new(sections[1].to_f(), sections[2].to_f());
        else
            shape = nil;
        end
        next if shape.nil?
        shape.print();
      rescue Exception => ex
        puts ex;
      end
    end
  end
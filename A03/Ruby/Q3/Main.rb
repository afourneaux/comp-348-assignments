require("./Circle.rb");
require("./Rectangle.rb");

shapes = {
  "Shape" => 0,
  "Rectangle" => 0,
  "Circle" => 0,
  "Ellipse" => 0
}

File.open("./shapes.txt", "r") do |file|
    file.each_line do |line|
      sections = line.split(" ");
      begin
        case sections[0]
        when "shape"
            shape = Shape.new();
        when "rectangle"
            shape = Rectangle.new(sections[1].to_f(), sections[2].to_f());
            shapes["Rectangle"] += 1
        when "circle"
            shape = Circle.new(sections[1].to_f());
            shapes["Circle"] += 1
        when "ellipse"
            shape = Ellipse.new(sections[1].to_f(), sections[2].to_f());
            shapes["Ellipse"] += 1
        else
            shape = nil;
        end
        next if shape.nil?
          shapes["Shape"] += 1
          shape.print();
      rescue Exception => ex
        puts ex;
      end
    end
  end
  
  puts ""
  puts "Statistics:"
  shapes.each_pair do |shape,count|
    puts "\t#{shape}(s): #{count}";
  end
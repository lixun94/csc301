package edu.toronto.csc301.grid.impl;

import edu.toronto.csc301.grid.GridCell;
import edu.toronto.csc301.grid.IGrid;
import edu.toronto.csc301.grid.IGridSerializerDeserializer;
import edu.toronto.csc301.grid.impl.RectangularGrid;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.lang.Math;

public class RectangularGridSerializerDeserializer implements IGridSerializerDeserializer {

    @Override
    public <T> void serialize(IGrid<T> grid, OutputStream output, Function<T, byte[]> item2byteArray)
            throws IOException {
        Iterator<GridCell> iter = grid.getGridCells();
        GridCell sw = iter.next();
        int max_x = sw.x;
        int max_y = sw.y;
        int min_x = sw.x;
        int min_y = sw.y;
        int total = 1;
        while (iter.hasNext()){
            total += 1;
            GridCell cell = iter.next();
            max_x = Math.max(cell.x, max_x);
            max_y = Math.max(cell.y, max_y);
            min_x = Math.min(cell.x, min_x);
            min_y = Math.min(cell.y, min_y);
        }
        int height = 0;
        int width = 0;
        if (sw != null){
            height = max_y - sw.y + 1;
            width = max_x - sw.x + 1;
        }
        if (total != height * width){
            throw new IllegalArgumentException();
        }
        Iterator<GridCell> iter_2 = grid.getGridCells();
        String all_items = new StringBuilder()
                .append(String.format("width: %d\n", width))
                .append(String.format("height: %d\n", height))
                .append(String.format("south-west: %d:%d\n", sw.x, sw.y))
                .toString();
        output.write(all_items.getBytes());
        while (iter_2.hasNext()){
            GridCell next = iter_2.next();
            all_items = next.x + ":" + next.y;
            if (grid.getItem(next) != null){
                all_items += " ";
                output.write(all_items.getBytes());
                byte [] bytearray = item2byteArray.apply(grid.getItem(next));
                output.write(bytearray);
                output.write("\n".getBytes());
            }
        }
    }

    @Override
    public <T> IGrid<T> deserialize(InputStream input, Function<byte[], T> byteArray2item) throws IOException {

        Map<GridCell, T> item_map = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line;
        int height, width;
        GridCell sw;
        line  =  in.readLine();
        width = Integer.parseInt(line.replace("\n","").split(" ")[1]);
        line  =  in.readLine();
        height = Integer.parseInt(line.replace("\n","").split(" ")[1]);
        line = in.readLine();
        int x,y;
        x = Integer.parseInt(line.replace("\n","").split(" ")[1].split(":")[0]);
        y = Integer.parseInt(line.replace("\n","").split(" ")[1].split(":")[1]);
        sw = GridCell.at(x, y);
        RectangularGrid<T> recgrid = new RectangularGrid<T>(width, height, sw);
        while ((line = in.readLine()) != null){
            String[] itemThisLine = line.replace("\n","").split(" ");
            T item = null;
            int item_x,item_y;
            item_x = Integer.parseInt(itemThisLine[0].split(":")[0]);
            item_y = Integer.parseInt(itemThisLine[0].split(":")[1]);
            if (itemThisLine.length > 1){
                item = byteArray2item.apply((itemThisLine[1].getBytes()));
            }
            GridCell itemcell = GridCell.at(item_x, item_y);
            item_map.put(itemcell, item);
        }
        recgrid.map(item_map);
        return recgrid;
    }

}


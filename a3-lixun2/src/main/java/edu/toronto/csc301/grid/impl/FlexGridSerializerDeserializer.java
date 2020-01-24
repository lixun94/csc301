package edu.toronto.csc301.grid.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

import edu.toronto.csc301.grid.GridCell;
import edu.toronto.csc301.grid.IGrid;
import edu.toronto.csc301.grid.IGridSerializerDeserializer;
import edu.toronto.csc301.grid.impl.FlexGrid;

public class FlexGridSerializerDeserializer implements IGridSerializerDeserializer {

    @Override
    public <T> void serialize(IGrid<T> grid, OutputStream output, Function<T, byte[]> item2byteArray)
            throws IOException {
        Iterator<GridCell> iterator = grid.getGridCells();
        String all_items;
        while (iterator.hasNext()){
            GridCell next = iterator.next();
            all_items = next.x + ":" + next.y;
            output.write(all_items.getBytes());
            if (grid.getItem(next) != null){
                output.write(" ".getBytes());
                byte [] byteArray = item2byteArray.apply(grid.getItem(next));
                output.write(byteArray);
            }
            output.write("\n".getBytes());
        }
    }

    @Override
    public <T> IGrid<T> deserialize(InputStream input, Function<byte[], T> byteArray2item) throws IOException {
        Map<GridCell, T> grid_map = new HashMap<>();
        ArrayList<GridCell> cells_list  = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line;
        FlexGrid<T> flexGrid = new FlexGrid<T>();
        while ((line = in.readLine()) != null){
            String itemThisLine = line.split("\n")[0];
            T item = null;
            int item_x,item_y;
            if (itemThisLine.contains(" ")){
                String [] coord_item = itemThisLine.split(" ");
                item_x = Integer.parseInt(coord_item[0].split(":")[0]);
                item_y = Integer.parseInt(coord_item[0].split(":")[1]);
                item = byteArray2item.apply((coord_item[1].getBytes()));
            }else{
                item_x = Integer.parseInt(itemThisLine.split(":")[0]);
                item_y = Integer.parseInt(itemThisLine.split(":")[1]);
            }
            GridCell itemcell = GridCell.at(item_x, item_y);
            grid_map.put(itemcell, item);
            cells_list.add(itemcell);
        }
        flexGrid.map(grid_map,cells_list);
        return flexGrid;
    }

}


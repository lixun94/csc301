package edu.toronto.csc301.grid.impl;

import edu.toronto.csc301.grid.GridCell;
import edu.toronto.csc301.grid.IGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FlexGrid<T> implements IGrid<T> {

    private Map<GridCell, T> grid_map = new HashMap<>();
    private ArrayList<GridCell> grid_list = new ArrayList<>();

    @Override
    public T getItem(GridCell cell){
        if (!grid_list.contains(cell)){
            throw new IllegalArgumentException();
        }
        return this.grid_map.get(cell);
    }

    @Override
    public Iterator<GridCell> getGridCells(){
        return this.grid_list.iterator();
    }

    @Override
    public boolean hasCell(GridCell cell){
        return this.grid_list.contains(cell);
    }

    public void map(Map<GridCell,T> grid_map, ArrayList<GridCell> grid_list){
        this.grid_map = grid_map;
        this.grid_list = grid_list;
    }
}

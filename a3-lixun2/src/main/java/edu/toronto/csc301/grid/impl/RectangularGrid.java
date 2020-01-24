package edu.toronto.csc301.grid.impl;

import edu.toronto.csc301.grid.GridCell;
import edu.toronto.csc301.grid.IGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RectangularGrid<T> implements IGrid<T> {

    private int width;
    private int height;
    private GridCell gridCell;
    private Map<GridCell, T> grid_map = new HashMap<>();

    public RectangularGrid(int width, int height, GridCell gridCell){
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException();
        }
        if (gridCell == null){
            throw new NullPointerException();
        }
        this.width = width;
        this.height = height;
        this.gridCell = gridCell;
    }

    public void map(Map<GridCell, T> grid_map){
        this.grid_map = grid_map;
    }

    @Override
    public T getItem(GridCell cell){
        if (cell.x > this.gridCell.x + this.width || cell.x < this.gridCell.x || cell.y > this.gridCell.y +
            this.height || cell.y < this.gridCell.y){
            throw new IllegalArgumentException();
        }
        else {
            return this.grid_map.get(cell);
        }
    }

    @Override
    public Iterator<GridCell> getGridCells() {
        ArrayList<GridCell> grid_list = new ArrayList<>();
        for (int x = this.gridCell.x; x < this.gridCell.x + this.width; x++) {
            for (int y = this.gridCell.y; y < this.gridCell.y + this.height; y++) {
                grid_list.add(GridCell.at(x, y));
            }
        }
        Iterator<GridCell> iterator = grid_list.iterator();
        return iterator;
    }

    @Override
    public boolean hasCell(GridCell cell){
        if(cell.x < this.gridCell.x + this.width & cell.x >= this.gridCell.x &
            cell.y < this.gridCell.y + this.height &
            cell.y >= this.gridCell.y){
            return true;
        }
        else{
            return false;
        }
    }

}
package com.example.snake_ladder;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int tileSize)
    {
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.LIGHTCORAL);
        setStroke(Color.BLACK);
    }
}

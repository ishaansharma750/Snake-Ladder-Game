package com.example.snake_ladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer,Integer>> positionCoordinate;
    private ArrayList<Integer>snakeLadder;

    public Board()
    {
        populatePositionCoordinates();
        setSnakeLadder();

    }


    public void setSnakeLadder()
    {
        snakeLadder = new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            snakeLadder.add(i);
        }
        // Climbing Ladder
        snakeLadder.set(4,25);
        snakeLadder.set(13,46);
        snakeLadder.set(33,49);
        snakeLadder.set(50,69);
        snakeLadder.set(42,63);
        snakeLadder.set(62,81);
        snakeLadder.set(74,92);

        // Snake Bite
        snakeLadder.set(27,5);
        snakeLadder.set(40,3);
        snakeLadder.set(43,18);
        snakeLadder.set(54,31);
        snakeLadder.set(66,45);
        snakeLadder.set(76,58);
        snakeLadder.set(89,53);
        snakeLadder.set(99,41);

    }

    private void populatePositionCoordinates()
    {
        positionCoordinate = new ArrayList<>();
        positionCoordinate.add(new Pair<>(0,0)); // Dummy values of board

        for(int i = 0; i< SnakeLadder.height; i++)
        {
            for (int j = 0; j < SnakeLadder.width; j++)
            {
                // X axis
                int x=0;
                if(i%2==0)
                {
                    x = j*SnakeLadder.tile_size + SnakeLadder.tile_size/2;
                }
                else
                {
                    x = SnakeLadder.height * SnakeLadder.tile_size - j*SnakeLadder.tile_size - SnakeLadder.tile_size/2;
                }
                // Y axis
                int y = SnakeLadder.height * SnakeLadder.tile_size - i*SnakeLadder.tile_size - SnakeLadder.tile_size/2;
                positionCoordinate.add(new Pair<>(x,y));
            }
        }
    }

    public int getXCoordinate(int position)
    {
        if(position>0 && position<=100)
        {
            return positionCoordinate.get(position).getKey();
        }
        return -1;
    }
    public int getYCoordinate(int position)
    {
        if(position>0 && position<=100)
        {
            return positionCoordinate.get(position).getValue();
        }
        return -1;
    }

    public int getSnakeLadder(int position)
    {
        return snakeLadder.get(position);
    }
    public static void main(String[] args) {
        Board board = new Board();

        for (int i = 0; i <board.positionCoordinate.size() ; i++)
        {
            System.out.println(i + " $X : " + board.positionCoordinate.get(i).getKey()
                    + "  Y: " + board.positionCoordinate.get(i).getValue());
        }

        }
    }


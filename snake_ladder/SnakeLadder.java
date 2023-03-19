package com.example.snake_ladder;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeLadder extends Application {

    // tile Size
    public static final int tile_size = 40, width = 10, height =10, buttonLine = height*tile_size + 50,infoLine = height*tile_size +20;
    Player playerFirst, playerSecond;
    int diceValue;
    boolean firstPlayerTurn = true,gameStart = false;

    private Pane createContent(){
        // Pane is used to create the frame
        Pane root = new Pane();
        root.setPrefSize(width* tile_size, height * tile_size +100);

        // putting 100 tiles on the UI -->
        for(int i=0;i<height;i++)
        {
            for (int j = 0; j < width; j++)
            {
                Tile tile = new Tile(tile_size);
                tile.setTranslateX(i* tile_size);
                tile.setTranslateY(j* tile_size);
                root.getChildren().addAll(tile);
            }
        }

        // Putting Image on the root pane -->
        Image img = new Image("C:\\Users\\ali\\IdeaProjects\\Snake_Ladder\\src\\main\\resources\\Snake-image.jpg");
        ImageView Game_image = new ImageView();
        Game_image.setFitWidth(width* tile_size);
        Game_image.setFitHeight(height* tile_size);
        Game_image.setImage(img);

        // Creating Buttons -->
        Button startButton = new Button("Start");
        startButton.setTranslateX(180);
        startButton.setTranslateY(buttonLine);

        // Player one button -->
        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(10);
        playerOneButton.setTranslateY(buttonLine);

        // Player two button-->
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(buttonLine);

        // Dice Label -->
        Label dice = new Label("Start the Game");
        dice.setTranslateX(160);
        dice.setTranslateY(infoLine);

        // Players -->
        playerFirst = new Player("Amit", Color.BLACK,tile_size/2);
        playerSecond = new Player("Suansh",Color.WHITE,tile_size/2-7);

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart)
                {
                    if(firstPlayerTurn)
                    {
                        diceValue = rollDice();
                        dice.setText("Dice : " + diceValue);
                        playerFirst.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerFirst.checkWinner())
                        {
                            dice.setText("Winner is : " + playerFirst.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn = true;
                            gameStart=false;
                        }
                    }
                }

            }
        });

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart)
                {
                    if(!firstPlayerTurn)
                    {
                        diceValue = rollDice();
                        dice.setText("Dice : " + diceValue);
                        playerSecond.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerSecond.checkWinner())
                        {
                            dice.setText("Winner is : " + playerSecond.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn = true;
                        }
                    }
                }
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                 gameStart = true;
                 startButton.setDisable(true);
                 playerFirst.setStart();
                 playerSecond.setStart();
            }
        });



        //  Root is for Placing items in the pane or in the Game board -->
        root.getChildren().addAll(startButton,playerOneButton,playerTwoButton,dice,Game_image);
        root.getChildren().addAll(playerFirst.getCoin(),playerSecond.getCoin());

        return root;
    }

    private  int rollDice()
    {
        return (int)(Math.random()*6+1);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
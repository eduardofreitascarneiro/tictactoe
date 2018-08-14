package br.com.portfolio.tictactoe.tictactoe;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.portfolio.classes.MyImageView;
import br.com.portfolio.classes.SquareTicTacToe;
import br.com.portfolio.classes.TicTacToeBoard;

public class TicTacToeActivity extends AppCompatActivity {

    private TicTacToeBoard board = new TicTacToeBoard();

    private ImageView squareL0C0;
    private ImageView squareL0C1;
    private ImageView squareL0C2;
    private ImageView squareL1C0;
    private ImageView squareL1C1;
    private ImageView squareL1C2;
    private ImageView squareL2C0;
    private ImageView squareL2C1;
    private ImageView squareL2C2;

    private boolean squareL0C0_b = false;
    private boolean squareL0C1_b = false;
    private boolean squareL0C2_b = false;
    private boolean squareL1C0_b = false;
    private boolean squareL1C1_b = false;
    private boolean squareL1C2_b = false;
    private boolean squareL2C0_b = false;
    private boolean squareL2C1_b = false;
    private boolean squareL2C2_b = false;

    private boolean resultDatabase = false;
    private boolean firstPlayer = true;
    private boolean lockBoard = false;
    private boolean gameStarted = false;

    private boolean  initialized = false;

    private ValueEventListener valueEventListenerBoard;
    private ArrayList<ImageView> squareList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        //Toast.makeText(this, "OnCreate()", Toast.LENGTH_SHORT).show();

            init();

            Toast.makeText(TicTacToeActivity.this, "Divirta-se...", Toast.LENGTH_SHORT).show();

            squareL0C0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL0C0_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL0C0_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 0, 0);
                    }
                }
            });

            squareL0C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL0C1_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL0C1_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 0, 1);
                    }

                }
            });

            squareL0C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL0C2_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL0C2_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 0, 2);
                    }

                }

            });

            squareL1C0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL1C0_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL1C0_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 1, 0);
                    }

                }
            });

            squareL1C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL1C1_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL1C1_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 1, 1);
                    }

                }
            });

            squareL1C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL1C2_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL1C2_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                    }
                });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 1, 2);
                    }

                }
            });

            squareL2C0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL2C0_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL2C0_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 2, 0);
                    }

                }
            });

            squareL2C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL2C1_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL2C1_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 2, 1);
                    }

                }
            });

            squareL2C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!squareL2C2_b && !lockBoard) {
                        lockBoard = true;
                        final DispatchGroup dispatchGroup = new DispatchGroup(new DispatchGroup.OnZeroedReferences() {
                            @Override
                            public void onZeroedReferences() {
                                if (resultDatabase) {
                                    squareL2C2_b = true;
                                    resultDatabase = false;
                                    //firstPlayer = !firstPlayer;
                                }
                            }
                        });

                        dispatchGroup.increment();

                        saveBoard(dispatchGroup, 2, 2);
                    }

                }
            });

    }

    public void init() {

        initialized = true;
        // board = new TicTacToeBoard(3,3);
        squareL0C0 = (ImageView) findViewById(R.id.squareL0C0);
        squareL0C1 = (ImageView) findViewById(R.id.squareL0C1);
        squareL0C2 = (ImageView) findViewById(R.id.squareL0C2);
        squareL1C0 = (ImageView) findViewById(R.id.squareL1C0);
        squareL1C1 = (ImageView) findViewById(R.id.squareL1C1);
        squareL1C2 = (ImageView) findViewById(R.id.squareL1C2);
        squareL2C0 = (ImageView) findViewById(R.id.squareL2C0);
        squareL2C1 = (ImageView) findViewById(R.id.squareL2C1);
        squareL2C2 = (ImageView) findViewById(R.id.squareL2C2);

        squareList = new ArrayList<>();
        squareList.add(squareL0C0);
        squareList.add(squareL0C1);
        squareList.add(squareL0C2);
        squareList.add(squareL1C0);
        squareList.add(squareL1C1);
        squareList.add(squareL1C2);
        squareList.add(squareL2C0);
        squareList.add(squareL2C1);
        squareList.add(squareL2C2);

        newGame();

    }


    public void saveBoard(final DispatchGroup dispatchGroup, final Integer axis_x, final Integer axis_y) {
        //TODO Salvar o tabuleiro no firebase
        updateBoard(axis_x, axis_y);

        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        firebase.child("Board").setValue(board).addOnCompleteListener(new OnCompleteListener<Void>() {
            //firebase.child("Board").setValue("board").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isComplete()) {
                    resultDatabase = true;
                    lockBoard = false;
                    //firstPlayer = !firstPlayer;

                    dispatchGroup.decrement();
                    updateScreen();

                }
            }
        });
    }

    public void saveBoard(TicTacToeBoard board_) {
        //TODO Salvar o tabuleiro no firebase
        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        firebase.child("Board").setValue(board_).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isComplete()) {
                    Toast.makeText(TicTacToeActivity.this, "Oponente, é sua vez.", Toast.LENGTH_SHORT).show();
                    loadGame();
                }
            }
        });
    }

    public void updateBoard(Integer axis_x, Integer axis_y) {
        for (SquareTicTacToe square : board.getSquareList()) {
            if (square.getAxis_x() == axis_x && square.getAxis_y() == axis_y) {
                if (firstPlayer) {
                    square.setValue("O");
                } else {
                    square.setValue("X");
                }
                //firstPlayer = !firstPlayer;
                saveBoard(board);
                //firstPlayer = !firstPlayer;
                break;
            }

        }
    }

    public void avaluateBoard() {
        //TODO Criar metodos/procedimentos de avaliação do tabuleiro

        SquareTicTacToe square00 = board.getSquareList().get(0);
        SquareTicTacToe square01 = board.getSquareList().get(1);
        SquareTicTacToe square02 = board.getSquareList().get(2);
        SquareTicTacToe square10 = board.getSquareList().get(3);
        SquareTicTacToe square11 = board.getSquareList().get(4);
        SquareTicTacToe square12 = board.getSquareList().get(5);
        SquareTicTacToe square20 = board.getSquareList().get(6);
        SquareTicTacToe square21 = board.getSquareList().get(7);
        SquareTicTacToe square22 = board.getSquareList().get(8);

        String winner = "";

        /* Verifing position 0,0  0,1  0,2 */
        if ( square00.getValue().equals( square01.getValue() ) &&  square01.getValue().equals( square02.getValue()  )) {
            winner = square00.getValue();
            if( winner.equals("X") ){
                squareL0C0.setImageResource(R.drawable.ic_x_win);
                squareL0C1.setImageResource(R.drawable.ic_x_win);
                squareL0C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL0C0.setImageResource(R.drawable.ic_y_win);
                squareL0C1.setImageResource(R.drawable.ic_y_win);
                squareL0C2.setImageResource(R.drawable.ic_y_win);
            }

        }

        /* Verifing position 1,0  1,1  1,2 */
        if (square10.getValue().equals(square11.getValue())  && square11.getValue().equals(square12.getValue() )) {
            winner = square10.getValue();
            if( winner.equals("X") ){
                squareL1C0.setImageResource(R.drawable.ic_x_win);
                squareL1C1.setImageResource(R.drawable.ic_x_win);
                squareL1C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL1C0.setImageResource(R.drawable.ic_y_win);
                squareL1C1.setImageResource(R.drawable.ic_y_win);
                squareL1C2.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 2,0  2,1  2,2 */
        if (square20.getValue().equals(square21.getValue()) && square21.getValue().equals(square22.getValue() )) {
            winner = square20.getValue();
            if( winner.equals("X") ){
                squareL2C0.setImageResource(R.drawable.ic_x_win);
                squareL2C1.setImageResource(R.drawable.ic_x_win);
                squareL2C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL2C0.setImageResource(R.drawable.ic_y_win);
                squareL2C1.setImageResource(R.drawable.ic_y_win);
                squareL2C2.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 0,0  1,0  2,0 */
        if (square00.getValue().equals(square10.getValue())  && square10.getValue().equals(square20.getValue() )) {
            winner = square00.getValue();
            if( winner.equals("X") ){
                squareL0C0.setImageResource(R.drawable.ic_x_win);
                squareL1C0.setImageResource(R.drawable.ic_x_win);
                squareL2C0.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL0C0.setImageResource(R.drawable.ic_y_win);
                squareL1C0.setImageResource(R.drawable.ic_y_win);
                squareL2C0.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 0,1  1,1  2,1 */
        if (square01.getValue().equals(square11.getValue()) && square11.getValue().equals(square21.getValue() )) {
            winner = square01.getValue();
            if( winner.equals("X") ){
                squareL0C1.setImageResource(R.drawable.ic_x_win);
                squareL1C1.setImageResource(R.drawable.ic_x_win);
                squareL2C1.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL0C1.setImageResource(R.drawable.ic_y_win);
                squareL1C1.setImageResource(R.drawable.ic_y_win);
                squareL2C1.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 0,2  1,2  2,2 */
        if (square02.getValue().equals(square12.getValue()) && square12.getValue().equals(square22.getValue() )) {
            winner = square02.getValue();
            if( winner.equals("X") ){
                squareL0C2.setImageResource(R.drawable.ic_x_win);
                squareL1C2.setImageResource(R.drawable.ic_x_win);
                squareL2C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL0C2.setImageResource(R.drawable.ic_y_win);
                squareL1C2.setImageResource(R.drawable.ic_y_win);
                squareL2C2.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 0,0  1,1  2,2 */
        if (square00.getValue().equals( square11.getValue() ) && square11.getValue().equals( square22.getValue() )) {
            winner = square00.getValue();
            if( winner.equals("X") ){
                squareL0C0.setImageResource(R.drawable.ic_x_win);
                squareL1C1.setImageResource(R.drawable.ic_x_win);
                squareL2C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL0C0.setImageResource(R.drawable.ic_y_win);
                squareL1C1.setImageResource(R.drawable.ic_y_win);
                squareL2C2.setImageResource(R.drawable.ic_y_win);
            }
        }

        /* Verifing position 2,0  1,1  0,2 */
        if (square20.getValue().equals( square11.getValue() ) && square11.getValue().equals( square02.getValue() )) {
            winner = square20.getValue();
            if( winner.equals("X") ){
                squareL2C0.setImageResource(R.drawable.ic_x_win);
                squareL1C1.setImageResource(R.drawable.ic_x_win);
                squareL0C2.setImageResource(R.drawable.ic_x_win);
            }else if ( winner.equals("O") ){
                squareL2C0.setImageResource(R.drawable.ic_y_win);
                squareL1C1.setImageResource(R.drawable.ic_y_win);
                squareL0C2.setImageResource(R.drawable.ic_y_win);
            }

        }

        if( !winner.equals("") ){
            drawResult(winner);
        }
    }

    public void drawResult(String winner) {
        //TODO Criar método/procedimento para mostrar a linha ganhadora
        Toast.makeText(this, "Congratulations, " + winner + " won! " , Toast.LENGTH_SHORT).show();
        finalizeGame();
    }

    public void drawImagePlayer(ImageView image) {
        //TODO Criar método/procedimento imprimir a figura escolhida pelo jogador
        if (firstPlayer) {
            image.setImageResource(R.drawable.ic_x);
        } else {
            image.setImageResource(R.drawable.ic_y);
        }

    }

    public void newGame() {
        squareL0C0_b = false;
        squareL0C1_b = false;
        squareL0C2_b = false;
        squareL1C0_b = false;
        squareL1C1_b = false;
        squareL1C2_b = false;
        squareL2C0_b = false;
        squareL2C1_b = false;
        squareL2C2_b = false;

        squareL0C0.setImageResource(R.drawable.background);
        squareL0C1.setImageResource(R.drawable.background);
        squareL0C2.setImageResource(R.drawable.background);
        squareL1C0.setImageResource(R.drawable.background);
        squareL1C1.setImageResource(R.drawable.background);
        squareL1C2.setImageResource(R.drawable.background);
        squareL2C0.setImageResource(R.drawable.background);
        squareL2C1.setImageResource(R.drawable.background);
        squareL2C2.setImageResource(R.drawable.background);

        board = new TicTacToeBoard(3, 3);
        saveBoard(board);

    }

    public void finalizeGame(){
        squareL0C0_b = true;
        squareL0C1_b = true;
        squareL0C2_b = true;
        squareL1C0_b = true;
        squareL1C1_b = true;
        squareL1C2_b = true;
        squareL2C0_b = true;
        squareL2C1_b = true;
        squareL2C2_b = true;
    }

    public void loadGame(){
        final DatabaseReference firebase = FirebaseDatabase.getInstance().getReference().child("Board").child("squareList");

        valueEventListenerBoard = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                board.getSquareList().clear();

                for (DataSnapshot dados: dataSnapshot.getChildren()){

                    SquareTicTacToe square = dados.getValue(SquareTicTacToe.class);
                    board.getSquareList().add(square);
                }

                firstPlayer = !firstPlayer;
                updateScreen();
                avaluateBoard();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //TODO ANYTHING
            }
        };
        firebase.addValueEventListener(valueEventListenerBoard);
    }


    public void updateScreen(){
        //loadGame();
        int index = 0;
        for(SquareTicTacToe square : board.getSquareList()){
            if ( square.getValue().equals("") ) {
                squareList.get(index).setImageResource( R.drawable.background );
            }else if( square.getValue().equals("X") ){
                squareList.get(index).setImageResource( R.drawable.ic_x );
            }else{
                squareList.get(index).setImageResource( R.drawable.ic_y );
            }
            index++;
        }

    }
}

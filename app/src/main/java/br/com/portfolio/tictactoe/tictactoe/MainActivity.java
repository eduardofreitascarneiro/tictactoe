package br.com.portfolio.tictactoe.tictactoe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import br.com.portfolio.classes.TicTacToeBoard;

public class MainActivity extends AppCompatActivity {

    private TicTacToeBoard board = new TicTacToeBoard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

//        DatabaseReference firebase =  FirebaseDatabase.getInstance().getReference();
//        firebase.child("Board").setValue(board).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isComplete()){
//                    Log.i("Teste", "gravou");
//                }else{
//                    Log.i("Teste", "não gravou");
//                }
//            }
//        });

    }

    public void init(){
        board = new TicTacToeBoard(3,3);
        Intent intent = new Intent(this, TicTacToeActivity.class);
        startActivity(intent);
        finish();
    }
}

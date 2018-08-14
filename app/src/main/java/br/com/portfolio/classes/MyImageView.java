package br.com.portfolio.classes;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;

public class MyImageView extends AppCompatImageView {

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MyImageView(Context context) {
        super(context);
    }
}

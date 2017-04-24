package com.example.cmltdstudent.inclassassignment11_ningelb;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MonumentViewHolder extends RecyclerView.ViewHolder {


    private CardView cardView;
    private TextView monumentNameText;
    private TextView monumentBuiltText;
    private TextView monumentVisitedText;
    private Context context;


    public MonumentViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        monumentNameText = (TextView) itemView.findViewById(R.id.monument_name);
        monumentBuiltText = (TextView) itemView.findViewById(R.id.monument_built);
        monumentVisitedText= (TextView) itemView.findViewById(R.id.monument_visited);
        this.context = itemView.getContext();
    }


    public void bind(final Monument monument) {
        monumentNameText.setText(monument.name);
        monumentBuiltText.setText("Built: " + monument.built);
        monumentVisitedText.setText("Alive: " + monument.visited);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, monumentNameText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

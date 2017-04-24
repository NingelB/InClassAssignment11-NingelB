package com.example.cmltdstudent.inclassassignment11_ningelb;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by cmltdstudent on 4/17/17.
 */

    public class MonumentAdapter extends FirebaseRecyclerAdapter<Monument, MonumentViewHolder> {


        public MonumentAdapter(Query ref) {
            super(Monument.class, R.layout.card_view_monument, MonumentViewHolder.class, ref);
        }


        @Override
        protected void populateViewHolder(MonumentViewHolder viewHolder, Monument monument, int position) {
            viewHolder.bind(monument);
        }
    }



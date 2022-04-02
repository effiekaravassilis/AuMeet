package com.bignerdranch.android.aumeet;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    TextView sendertv, recievertv;
    ImageView iv_sender, iv_reciever;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void SetMessage(Application application, String message, String time, String date,
                           String type, String senderuid, String recieveruid) {
        sendertv = itemView.findViewById(R.id.sender_tv);
        recievertv = itemView.findViewById(R.id.reciever_tv);

        iv_reciever = itemView.findViewById(R.id.iv_reciever);
        iv_sender = itemView.findViewById(R.id.iv_sender);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentUid = user.getUid();

        if (type.equals("text")) {
            if (currentUid.equals(senderuid)) {

                recievertv.setVisibility(View.GONE);
                sendertv.setText(message);

            } else if (currentUid.equals(recieveruid)) {
                sendertv.setVisibility(View.GONE);
                recievertv.setText(message);
            }

        } else if(type.equals("iv")) {

            if (currentUid.equals(senderuid)) {
                recievertv.setVisibility(View.GONE);
                sendertv.setVisibility(View.GONE);
                iv_sender.setVisibility(View.VISIBLE);
                Picasso.get().load(message).into(iv_sender);


            } else if (currentUid.equals(recieveruid)){
                recievertv.setVisibility(View.GONE);
                sendertv.setVisibility(View.GONE);
                iv_reciever.setVisibility(View.VISIBLE);
                Picasso.get().load(message).into(iv_reciever);

            }

        }


    }
}